package com.senlainc.miliuta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senlainc.miliuta.controller.exceptions.NoSuchItemException;
import com.senlainc.miliuta.dto.CredentialsDTO;
import com.senlainc.miliuta.services.api.ICredentialsService;

@RestController
@RequestMapping("/creds")
public class CredentialsController {

	@Autowired
	private ICredentialsService<CredentialsDTO> credentialsService;

	@GetMapping
	public List<CredentialsDTO> getCredentials() {
		return credentialsService.getAll();
	}

	@GetMapping("/{id}")
	public CredentialsDTO getCredentials(@PathVariable Integer id) throws NoSuchItemException {
		CredentialsDTO credentialsDTO = null;
		try {
			credentialsDTO = credentialsService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return credentialsDTO;
	}

	@PostMapping
	public boolean saveCredentials(@RequestBody CredentialsDTO creds) {
		try {
			credentialsService.save(creds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteCredentials(@PathVariable Integer id) {
		try {
			credentialsService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateCredentials(@RequestBody CredentialsDTO creds) {
		try {
			credentialsService.update(creds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
