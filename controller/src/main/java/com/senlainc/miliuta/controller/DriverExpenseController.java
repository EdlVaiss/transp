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
import com.senlainc.miliuta.dto.DriverExpenseDTO;
import com.senlainc.miliuta.services.api.IDriverExpenseService;

@RestController
@RequestMapping("/driverExpense")
public class DriverExpenseController {

	private static final Logger logger = Logger.getLogger(DriverExpenseController.class);
			
	@Autowired
	private IDriverExpenseService<DriverExpenseDTO> driverExpenseService;

	@GetMapping
	public List<DriverExpenseDTO> getDriverExpenses() {
		logger.debug("List of items asked");
		return driverExpenseService.getAll();
	}

	@GetMapping("/{id}")
	public DriverExpenseDTO getDriverExpense(@PathVariable Integer id) throws NoSuchItemException {
		DriverExpenseDTO driverExpenseDTO = null;
		try {
			logger.debug("Item asked with id: " + id);
			driverExpenseDTO = driverExpenseService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return driverExpenseDTO;
	}

	@PostMapping
	public boolean saveDriverExpense(@RequestBody DriverExpenseDTO driverExpenseDTO) {
		try {
			logger.debug("Trying to save item...");
			driverExpenseService.save(driverExpenseDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteDriverExpense(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			driverExpenseService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateDriverExpense(@RequestBody DriverExpenseDTO driverExpenseDTO) {
		try {
			logger.debug("Trying to update item with id: " + driverExpenseDTO.getId());
			driverExpenseService.update(driverExpenseDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + driverExpenseDTO.getId());
			return false;
		}
	}
}
