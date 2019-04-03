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
import com.senlainc.miliuta.dto.CarExpenseTypeDTO;
import com.senlainc.miliuta.services.api.ICarExpenseTypeService;

@RestController
@RequestMapping("/carExpenseType")
public class CarExpenseTypeController {

	@Autowired
	private ICarExpenseTypeService<CarExpenseTypeDTO> carExpenseTypeService;

	@GetMapping
	public List<CarExpenseTypeDTO> getCarExpenseTypes() {
		return carExpenseTypeService.getAll();
	}

	@GetMapping("/{id}")
	public CarExpenseTypeDTO getCarExpenseType(@PathVariable Integer id) throws NoSuchItemException {
		CarExpenseTypeDTO carExpenseTypeDTO = null;
		try {
			carExpenseTypeDTO = carExpenseTypeService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return carExpenseTypeDTO;
	}

	@PostMapping
	public boolean saveCarExpenseType(@RequestBody CarExpenseTypeDTO CarExpenseTypeDTO) {
		return carExpenseTypeService.save(CarExpenseTypeDTO);
	}

	@DeleteMapping("/{id}")
	public boolean deleteCarExpenseType(@PathVariable Integer id) {
		try {
			carExpenseTypeService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateCarExpenseType(@RequestBody CarExpenseTypeDTO CarExpenseTypeDTO) {
		try {
			carExpenseTypeService.update(CarExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
