package com.senlainc.miliuta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.model.creds.User;
import com.senlainc.miliuta.services.api.ICarService;
import com.senlainc.miliuta.services.api.IUserService;

@Service
public class UserService extends AbstractService implements IUserService<User> {

	@Transactional
	@Override
	public void save(User item) {
		userDAO.create(item);
	}

	@Transactional
	@Override
	public List<User> getAll() {
		return userDAO.readAll();
	}

	@Transactional
	@Override
	public User getById(Integer id) {
		return userDAO.getById(id);
	}

	@Transactional
	@Override
	public void update(User item) {
		userDAO.update(item);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		userDAO.delete(userDAO.getById(id));
	}
}
