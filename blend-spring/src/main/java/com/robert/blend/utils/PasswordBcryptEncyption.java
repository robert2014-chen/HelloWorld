package com.robert.blend.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordBcryptEncyption {

	public static String bcryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
}
