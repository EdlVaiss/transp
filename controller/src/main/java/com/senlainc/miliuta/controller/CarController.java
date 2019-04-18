package com.senlainc.miliuta.controller;

import java.util.List;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(CarController.class);

	@Autowired
	private ICarService<CarDTO> carService;

	@GetMapping
	public List<CarDTO> getCars() {
		logger.debug("List of items asked");
		return carService.getAll();
	}

	@GetMapping("/{id}")
	public CarDTO getCar(@PathVariable Integer id) throws NoSuchItemException {
		CarDTO carDTO = null;
		try {
			logger.debug("Item asked with id: " + id);
			carDTO = carService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return carDTO;
	}

	@PostMapping
	public boolean saveCar(@RequestBody CarDTO carDTO) {
		try {
			logger.debug("Trying to save item...");
			carService.save(carDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteCar(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			carService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateCar(@RequestBody CarDTO carDTO) {
		try {
			logger.debug("Trying to update item with id: " + carDTO.getId());
			carService.update(carDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + carDTO.getId());
			return false;
		}
	}
}
