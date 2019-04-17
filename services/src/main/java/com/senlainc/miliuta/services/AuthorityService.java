package com.senlainc.miliuta.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.model.creds.Authority;
import com.senlainc.miliuta.services.api.IAuthorityService;

@Service
public class AuthorityService extends AbstractService implements IAuthorityService<Authority> {

	@Transactional
	@Override
	public void save(Authority item) {
		authorityDAO.create(item);
	}

	@Transactional
	@Override
	public List<Authority> getAll() {
		return authorityDAO.readAll();
	}

	@Transactional
	@Override
	public Authority getById(Integer id) {
		return authorityDAO.getById(id);
	}

	@Transactional
	@Override
	public void update(Authority item) {
		authorityDAO.update(item);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		authorityDAO.delete(authorityDAO.getById(id));
	}
}
