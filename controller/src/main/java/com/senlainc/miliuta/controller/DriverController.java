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
import com.senlainc.miliuta.dto.DriverDTO;
import com.senlainc.miliuta.services.api.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	private static final Logger logger = Logger.getLogger(DriverController.class);
			
	@Autowired
	private IDriverService<DriverDTO> driverService;

	@GetMapping
	public List<DriverDTO> getDrivers() {
		logger.debug("List of items asked");
		return driverService.getAll();
	}

	@GetMapping("/{id}")
	public DriverDTO getDriver(@PathVariable Integer id) throws NoSuchItemException {
		DriverDTO driverDTO = null;
		try {
			logger.debug("Item asked with id: " + id);
			driverDTO = driverService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return driverDTO;
	}

	@PostMapping
	public boolean saveDriver(@RequestBody DriverDTO driverDTO) {
		try {
			logger.debug("Trying to save item...");
			driverService.save(driverDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteDriver(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			driverService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateDriver(@RequestBody DriverDTO driverDTO) {
		try {
			logger.debug("Trying to update item with id: " + driverDTO.getId());
			driverService.update(driverDTO);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + driverDTO.getId());
			return false;
		}
	}
}
