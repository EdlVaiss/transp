package com.senlainc.miliuta.services.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncoder implements IEncryptor {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public String encrypt(String strToEncrypt) {
		return encoder.encode(strToEncrypt);
	}

}
