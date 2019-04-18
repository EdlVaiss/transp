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
import com.senlainc.miliuta.model.creds.User;
import com.senlainc.miliuta.services.api.creds.IUserService;

@RestController
@RequestMapping("/creds/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService<User> userService;

	@GetMapping
	public List<User> getUsers() {
		logger.debug("List of items asked");
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) throws NoSuchItemException {
		User user = null;
		try {
			logger.debug("Item asked with id: " + id);
			user = userService.getById(id);
		} catch (NullPointerException e) {
			logger.info("No item found with id: " + id);
			throw new NoSuchItemException(id);
		}
		return user;
	}

	@PostMapping
	public boolean saveUser(@RequestBody User user) {
		try {
			logger.debug("Trying to save item...");
			userService.save(user);
			return true;
		} catch (Exception e) {
			logger.info("Failed to save new item");
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable Integer id) {
		try {
			logger.debug("Trying to delete item with id: " + id);
			userService.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.info("Failed to delete item with id: " + id);
			return false;
		}
	}

	@PutMapping
	public boolean updateUser(@RequestBody User user) {
		try {
			logger.debug("Trying to update item with id: " + user.getId());
			userService.update(user);
			return true;
		} catch (Exception e) {
			logger.info("Failed to update item with id: " + user.getId());
			return false;
		}
	}

}
