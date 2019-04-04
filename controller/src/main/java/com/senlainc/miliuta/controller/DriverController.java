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
import com.senlainc.miliuta.dto.DriverDTO;
import com.senlainc.miliuta.services.api.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private IDriverService<DriverDTO> driverService;

	@GetMapping
	public List<DriverDTO> getDrivers() {
		return driverService.getAll();
	}

	@GetMapping("/{id}")
	public DriverDTO getDriver(@PathVariable Integer id) throws NoSuchItemException {
		DriverDTO driverDTO = null;
		try {
			driverDTO = driverService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return driverDTO;
	}

	@PostMapping
	public boolean saveDriver(@RequestBody DriverDTO DriverDTO) {
		try {
			driverService.save(DriverDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteDriver(@PathVariable Integer id) {
		try {
			driverService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateDriver(@RequestBody DriverDTO DriverDTO) {
		try {
			driverService.update(DriverDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
