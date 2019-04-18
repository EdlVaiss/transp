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
import com.senlainc.miliuta.dto.DriverExpenseTypeDTO;
import com.senlainc.miliuta.services.api.IDriverExpenseTypeService;

@RestController
@RequestMapping("/driverExpenseType")
public class DriverExpenseTypeController {

	private static final Logger logger = Logger.getLogger(DriverExpenseTypeController.class);
	
	@Autowired
	private IDriverExpenseTypeService<DriverExpenseTypeDTO> driverExpenseTypeService;

	@GetMapping()
	public List<DriverExpenseTypeDTO> getDriverExpenseTypes() {
		logger.debug("List of items asked");
		return driverExpenseTypeService.getAll();
	}

	@GetMapping("/{id}")
	public DriverExpenseTypeDTO getDriverExpenseType(@PathVariable Integer id) throws NoSuchItemException {
		DriverExpenseTypeDTO driverExpenseTypeDTO = null;
		try {
			logger.debug("Item asked with id: " + id);
			driverExpenseTypeDTO = driverExpenseTypeService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return driverExpenseTypeDTO;
	}

	@PostMapping
	public boolean saveDriverExpenseType(@RequestBody DriverExpenseTypeDTO driverExpenseTypeDTO) {
		try {
			logger.debug("Trying to save item...");
			driverExpenseTypeService.save(driverExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteDriverExpenseType(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			driverExpenseTypeService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateDriverExpenseType(@RequestBody DriverExpenseTypeDTO driverExpenseTypeDTO) {
		try {
			logger.debug("Trying to update item with id: " + driverExpenseTypeDTO.getId());
			driverExpenseTypeService.update(driverExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + driverExpenseTypeDTO.getId());
			return false;
		}
	}
}
