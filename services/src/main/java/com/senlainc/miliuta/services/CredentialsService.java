package com.senlainc.miliuta.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senlainc.miliuta.dto.CredentialsDTO;
import com.senlainc.miliuta.services.api.ICredentialsService;
import com.senlainc.miliuta.services.utils.TokenGenerator;

@Service
public class CredentialsService extends AbstractService implements ICredentialsService<CredentialsDTO> {
	private static final Logger logger = Logger.getLogger(CredentialsService.class);

	@Transactional
	@Override
	public void save(CredentialsDTO item) {
		String token = "";
		try {
			token = TokenGenerator.generateToken(item.getLogin(), item.getPassword());
		} catch (NoSuchAlgorithmException e) {
			logger.warn("Failed to create token!");
		}
		item.setToken(token);
		credentialsDAO.create(item.toModel());
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
