package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.CarDTO;
import com.senlainc.miliuta.services.api.ICarService;

@Service
public class CarService extends AbstractService implements ICarService<CarDTO> {

	@Transactional
	@Override
	public void save(CarDTO item) {
		carDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<CarDTO> getAll() {
		return carDAO.readAll().stream().map(CarDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CarDTO getById(Integer id) {
		return new CarDTO(carDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(CarDTO item) {
		carDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		carDAO.delete(carDAO.getById(id));
	}
}
