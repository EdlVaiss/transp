package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.DriverExpenseDTO;
import com.senlainc.miliuta.services.api.IDriverExpenseService;

@Service
public class DriverExpenseService extends AbstractService implements IDriverExpenseService<DriverExpenseDTO> {

	@Transactional
	@Override
	public void save(DriverExpenseDTO item) {
		driverExpenseDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<DriverExpenseDTO> getAll() {
		return driverExpenseDAO.readAll().stream().map(DriverExpenseDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public DriverExpenseDTO getById(Integer id) {
		return new DriverExpenseDTO(driverExpenseDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(DriverExpenseDTO item) {
		driverExpenseDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		driverExpenseDAO.delete(driverExpenseDAO.getById(id));
	}
}
