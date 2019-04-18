package com.senlainc.miliuta.controller.creds;

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
import com.senlainc.miliuta.model.creds.Authority;
import com.senlainc.miliuta.services.api.creds.IAuthorityService;

@RestController
@RequestMapping("/creds/roles")
public class AuthorityController {

	@Autowired
	private IAuthorityService<Authority> authorityService;

	@GetMapping
	public List<Authority> getAuthority() {
		return authorityService.getAll();
	}

	@GetMapping("/{id}")
	public Authority getAuthority(@PathVariable Integer id) throws NoSuchItemException {
		Authority authority = null;
		try {
			authority = authorityService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return authority;
	}

	@PostMapping
	public boolean saveAuthority(@RequestBody Authority authority) {
		try {
			authorityService.save(authority);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteAuthority(@PathVariable Integer id) {
		try {
			authorityService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateAuthority(@RequestBody Authority authority) {
		try {
			authorityService.update(authority);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
