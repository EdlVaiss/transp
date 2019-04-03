package com.senlainc.miliuta.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee Not Found") // 404
public class NoSuchItemException extends Exception {

	private static final long serialVersionUID = 5360899666393443724L;

	public NoSuchItemException(Integer id) {
		super("No item found with id: " + id);
	}

}
