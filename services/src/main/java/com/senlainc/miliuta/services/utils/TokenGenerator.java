package com.senlainc.miliuta.services.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class TokenGenerator {
	public static String generateToken(String login, String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update((login + password).getBytes());
		byte[] digest = md.digest();
		String token = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return token;
	}
}
