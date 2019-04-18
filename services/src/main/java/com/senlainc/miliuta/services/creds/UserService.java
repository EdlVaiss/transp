package com.senlainc.miliuta.services.creds;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.model.creds.User;
import com.senlainc.miliuta.services.AbstractService;
import com.senlainc.miliuta.services.api.creds.IUserService;
import com.senlainc.miliuta.services.utils.IEncryptor;

@Service
public class UserService extends AbstractService implements IUserService<User> {

	@Autowired
	private IEncryptor encryptor;
	
	@Transactional
	@Override
	public void save(User item) {
		String password = item.getPassword();
		String encryptedPassword = encryptor.encrypt(password);
		item.setPassword(encryptedPassword);
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
