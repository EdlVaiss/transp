package com.senlainc.miliuta.controller.creds;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.senlainc.miliuta.model.creds.Authority;
import com.senlainc.miliuta.services.api.creds.IAuthorityService;

@RestController
@RequestMapping("/creds/roles")
public class AuthorityController {

	private static final Logger logger = Logger.getLogger(AuthorityController.class);
	
	@Autowired
	private IAuthorityService<Authority> authorityService;

	@GetMapping
	public List<Authority> getAuthorities() {
		logger.debug("List of items asked");
		return authorityService.getAll();
	}

	@GetMapping("/{id}")
	public Authority getAuthority(@PathVariable Integer id) throws NoSuchItemException {
		Authority authority = null;
		try {
			logger.debug("Item asked with id: " + id);
			authority = authorityService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return authority;
	}

	@PostMapping
	public boolean saveAuthority(@RequestBody Authority authority) {
		try {
			logger.debug("Trying to save item...");
			authorityService.save(authority);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteAuthority(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			authorityService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateAuthority(@RequestBody Authority authority) {
		try {
			logger.debug("Trying to update item with id: " + authority.getId());
			authorityService.update(authority);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + authority.getId());
			return false;
		}
	}

}
