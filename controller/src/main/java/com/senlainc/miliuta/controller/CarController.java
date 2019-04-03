package com.senlainc.miliuta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senlainc.miliuta.controller.exceptions.NoSuchItemException;
import com.senlainc.miliuta.dto.CarDTO;
import com.senlainc.miliuta.services.api.ICarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private ICarService<CarDTO> carService;

	@GetMapping
	public List<CarDTO> getCars() {
		return carService.getAll();
	}

	@GetMapping("/{id}")
	public CarDTO getCar(@PathVariable Integer id) throws NoSuchItemException {
		CarDTO carDTO = null;
		try {
			carDTO = carService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return carDTO;
	}

	@PostMapping
	public boolean saveCar(@RequestBody CarDTO car) {
		return carService.save(car);
	}

	@DeleteMapping("/{id}")
	public boolean deleteCar(@PathVariable Integer id) {
		try {
			carService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateCar(@RequestBody CarDTO car) {
		try {
			carService.update(car);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
