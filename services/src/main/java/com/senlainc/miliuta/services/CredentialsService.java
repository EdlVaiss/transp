package com.senlainc.miliuta.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.CredentialsDTO;
import com.senlainc.miliuta.services.api.ICredentialsService;
import com.senlainc.miliuta.services.utils.TokenGenerator;

@Service
public class CredentialsService extends AbstractService implements ICredentialsService<CredentialsDTO> {

	@Transactional
	@Override
	public boolean save(CredentialsDTO item) {
		String token ="";
		try {
			token = TokenGenerator.generateToken(item.getLogin(), item.getPassword());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't create token!");
			e.printStackTrace();
		}
		item.setToken(token);
		return credentialsDAO.create(item.toModel());
	}

	@Transactional
	@Override
	public List<CredentialsDTO> getAll() {
		return credentialsDAO.readAll().stream().map(CredentialsDTO::new).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CredentialsDTO getById(Integer id) {
		return new CredentialsDTO(credentialsDAO.getById(id));
	}

	@Transactional
	@Override
	public void update(CredentialsDTO item) {
		credentialsDAO.update(item.toModel());
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		credentialsDAO.delete(credentialsDAO.getById(id));
	}

}
