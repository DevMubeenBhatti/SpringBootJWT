package com.spring.security.jwt.spring.jwt.security.service;
import java.util.Optional;

import com.spring.security.jwt.spring.jwt.security.entity.User;


public interface UserService {

	Integer saveUser(User user);
	
	Optional<User> findByUsername(String username);
}