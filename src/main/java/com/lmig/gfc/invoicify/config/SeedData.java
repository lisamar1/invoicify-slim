package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepository, PasswordEncoder encoder) {
		String encodedPassword = encoder.encode("password");
		User user = new User();
		user.setUsername("admin");
		user.setPassword(encodedPassword);
		user.addRole("ADMIN");
		userRepository.save(user);
		
		encodedPassword = encoder.encode("password");
		user = new User();
		user.setUsername("clerk");
		user.setPassword(encodedPassword);
		user.addRole("CLERK");
		userRepository.save(user);
		
		encodedPassword = encoder.encode("password");
		user = new User();
		user.setUsername("accountant");
		user.setPassword(encodedPassword);
		user.addRole("ACCOUNTANT");
		userRepository.save(user);
	}

}