package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.CarExpenseDTO;
import com.senlainc.miliuta.model.CarExpense;
import com.senlainc.miliuta.services.api.ICarExpenseService;

@Service
public class CarExpenseService extends AbstractService implements ICarExpenseService<CarExpenseDTO> {

	@Transactional
	@Override
	public void save(CarExpenseDTO item) {
		carExpenseDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<CarExpenseDTO> getAll() {
		return carExpenseDAO.readAll().stream().map(CarExpenseDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CarExpenseDTO getById(Integer id) {
		return new CarExpenseDTO(carExpenseDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(CarExpenseDTO item) {
		carExpenseDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		carExpenseDAO.delete(carExpenseDAO.getById(id));
	}

	@Override
	public List<Object[]> readAllExt() {
		List<Object[]> carExpenses = carExpenseDAO.readAllExt();
		carExpenses = carExpenses.stream().map(obj -> {
			Object[] temp = new Object[3];
			temp[0] = new CarExpenseDTO((CarExpense) obj[0]);
			temp[1] = obj[1];
			temp[2] = obj[2];
			return temp;
		}).collect(Collectors.toList());
		return carExpenses;
	}
}
