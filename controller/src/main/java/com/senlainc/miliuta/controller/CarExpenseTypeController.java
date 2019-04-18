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
import com.senlainc.miliuta.dto.CarExpenseTypeDTO;
import com.senlainc.miliuta.services.api.ICarExpenseTypeService;

@RestController
@RequestMapping("/carExpenseType")
public class CarExpenseTypeController {
	private static final Logger logger = Logger.getLogger(CarExpenseTypeController.class);
	
	@Autowired
	private ICarExpenseTypeService<CarExpenseTypeDTO> carExpenseTypeService;

	@GetMapping
	public List<CarExpenseTypeDTO> getCarExpenseTypes() {
		logger.debug("List of items asked");
		return carExpenseTypeService.getAll();
	}

	@GetMapping("/{id}")
	public CarExpenseTypeDTO getCarExpenseType(@PathVariable Integer id) throws NoSuchItemException {
		CarExpenseTypeDTO carExpenseTypeDTO = null;
		try {
			logger.debug("Item asked with id: " + id);
			carExpenseTypeDTO = carExpenseTypeService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return carExpenseTypeDTO;
	}

	@PostMapping
	public boolean saveCarExpenseType(@RequestBody CarExpenseTypeDTO carExpenseTypeDTO) {
		try {
			logger.debug("Trying to save item...");
			carExpenseTypeService.save(carExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteCarExpenseType(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			carExpenseTypeService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateCarExpenseType(@RequestBody CarExpenseTypeDTO carExpenseTypeDTO) {
		try {
			logger.debug("Trying to update item with id: " + carExpenseTypeDTO.getId());
			carExpenseTypeService.update(carExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + carExpenseTypeDTO.getId());
			return false;
		}
	}
}
