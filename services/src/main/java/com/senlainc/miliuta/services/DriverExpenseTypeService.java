package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.DriverExpenseTypeDTO;
import com.senlainc.miliuta.services.api.IDriverExpenseTypeService;

@Service
public class DriverExpenseTypeService extends AbstractService implements IDriverExpenseTypeService<DriverExpenseTypeDTO> {

	@Transactional
	@Override
	public boolean save(DriverExpenseTypeDTO item) {
		return driverExpenseTypeDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<DriverExpenseTypeDTO> getAll() {
		return driverExpenseTypeDAO.readAll().stream().map(DriverExpenseTypeDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public DriverExpenseTypeDTO getById(Integer id) {
		return new DriverExpenseTypeDTO(driverExpenseTypeDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(DriverExpenseTypeDTO item) {
		driverExpenseTypeDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		driverExpenseTypeDAO.delete(driverExpenseTypeDAO.getById(id));
	}
}
