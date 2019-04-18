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
import com.senlainc.miliuta.model.creds.User;
import com.senlainc.miliuta.services.api.creds.IUserService;

@RestController
@RequestMapping("/creds/user")
public class UserController {

	@Autowired
	private IUserService<User> userService;

	@GetMapping
	public List<User> getUser() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) throws NoSuchItemException {
		User user = null;
		try {
			user = userService.getById(id);
		} catch (NullPointerException e) {
			throw new NoSuchItemException(id);
		}
		return user;
	}

	@PostMapping
	public boolean saveUser(@RequestBody User user) {
		try {
			userService.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable Integer id) {
		try {
			userService.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping
	public boolean updateUser(@RequestBody User user) {
		try {
			userService.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
