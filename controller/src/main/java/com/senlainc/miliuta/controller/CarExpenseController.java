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
import com.senlainc.miliuta.dto.CarExpenseDTO;
import com.senlainc.miliuta.services.api.ICarExpenseService;

@RestController
@RequestMapping("/carExpense")
public class CarExpenseController {
	private static final Logger logger = Logger.getLogger(CarExpenseController.class);

	@Autowired
	private ICarExpenseService<CarExpenseDTO> carExpenseService;

	@GetMapping("/ext")
	public List<Object[]> getCarExpensesExt() {
		logger.debug("Extended list items asked");
		return carExpenseService.readAllExt();
	}

	@GetMapping
	public List<CarExpenseDTO> getCarExpenses() {
		logger.debug("List of items asked");
		return carExpenseService.getAll();
	}

	@GetMapping("/{id}")
	public CarExpenseDTO getCarExpense(@PathVariable Integer id) throws NoSuchItemException {
		CarExpenseDTO carExpense = null;
		try {
			logger.debug("Item asked with id: " + id);
			carExpense = carExpenseService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return carExpense;
	}

	@PostMapping
	public boolean saveCarExpense(@RequestBody CarExpenseDTO carExpenseDTO) {
		try {
			logger.debug("Trying to save item...");
			carExpenseService.save(carExpenseDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteCarExpense(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			carExpenseService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateCarExpense(@RequestBody CarExpenseDTO carExpenseDTO) {
		try {
			logger.debug("Trying to update item with id: " + carExpenseDTO.getId());
			carExpenseService.update(carExpenseDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + carExpenseDTO.getId());
			return false;
		}
	}
}
