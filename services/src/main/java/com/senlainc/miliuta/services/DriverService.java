package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.DriverDTO;
import com.senlainc.miliuta.services.api.IDriverService;

@Service
public class DriverService extends AbstractService implements IDriverService<DriverDTO> {

	@Transactional
	@Override
	public void save(DriverDTO item) {
		driverDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<DriverDTO> getAll() {
		return driverDAO.readAll().stream().map(DriverDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public DriverDTO getById(Integer id) {
		return new DriverDTO(driverDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(DriverDTO item) {
		driverDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		driverDAO.delete(driverDAO.getById(id));
	}
}
