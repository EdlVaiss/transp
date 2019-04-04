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
import com.senlainc.miliuta.dto.DriverExpenseTypeDTO;
import com.senlainc.miliuta.services.api.IDriverExpenseTypeService;

@RestController
@RequestMapping("/driverExpenseType")
public class DriverExpenseTypeController {

	@Autowired
	private IDriverExpenseTypeService<DriverExpenseTypeDTO> driverExpenseTypeService;

	@GetMapping()
	public List<DriverExpenseTypeDTO> getDriverExpenseTypes() {
		return driverExpenseTypeService.getAll();
	}

	@GetMapping("/{id}")
	public DriverExpenseTypeDTO getDriverExpenseType(@PathVariable Integer id) throws NoSuchItemException {
		DriverExpenseTypeDTO driverExpenseTypeDTO = null;
		try {
			driverExpenseTypeDTO = driverExpenseTypeService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return driverExpenseTypeDTO;
	}

	@PostMapping
	public boolean saveDriverExpenseType(@RequestBody DriverExpenseTypeDTO DriverExpenseTypeDTO) {
		try {
			driverExpenseTypeService.save(DriverExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteDriverExpenseType(@PathVariable Integer id) {
		try {
			driverExpenseTypeService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateDriverExpenseType(@RequestBody DriverExpenseTypeDTO DriverExpenseTypeDTO) {
		try {
			driverExpenseTypeService.update(DriverExpenseTypeDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
