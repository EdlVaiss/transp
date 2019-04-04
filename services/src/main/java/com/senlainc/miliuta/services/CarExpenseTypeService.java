package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.CarExpenseTypeDTO;
import com.senlainc.miliuta.services.api.ICarExpenseTypeService;

@Service
public class CarExpenseTypeService extends AbstractService implements ICarExpenseTypeService<CarExpenseTypeDTO> {

	@Transactional
	@Override
	public void save(CarExpenseTypeDTO item) {
		carExpenseTypeDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<CarExpenseTypeDTO> getAll() {
		return carExpenseTypeDAO.readAll().stream().map(CarExpenseTypeDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CarExpenseTypeDTO getById(Integer id) {
		return new CarExpenseTypeDTO(carExpenseTypeDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(CarExpenseTypeDTO item) {
		carExpenseTypeDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		carExpenseTypeDAO.delete(carExpenseTypeDAO.getById(id));
	}
}
