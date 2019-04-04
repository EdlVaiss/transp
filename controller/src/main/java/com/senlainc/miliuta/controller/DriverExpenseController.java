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
import com.senlainc.miliuta.dto.DriverExpenseDTO;
import com.senlainc.miliuta.services.api.IDriverExpenseService;

@RestController
@RequestMapping("/driverExpense")
public class DriverExpenseController {

	@Autowired
	private IDriverExpenseService<DriverExpenseDTO> driverExpenseService;

	@GetMapping
	public List<DriverExpenseDTO> getDriverExpenses() {
		return driverExpenseService.getAll();
	}

	@GetMapping("/{id}")
	public DriverExpenseDTO getDriverExpense(@PathVariable Integer id) throws NoSuchItemException {
		DriverExpenseDTO driverExpenseDTO = null;
		try {
			driverExpenseDTO = driverExpenseService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return driverExpenseDTO;
	}

	@PostMapping
	public boolean saveDriverExpense(@RequestBody DriverExpenseDTO DriverExpenseDTO) {
		try {
			driverExpenseService.save(DriverExpenseDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteDriverExpense(@PathVariable Integer id) {
		try {
			driverExpenseService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateDriverExpense(@RequestBody DriverExpenseDTO DriverExpenseDTO) {
		try {
			driverExpenseService.update(DriverExpenseDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
