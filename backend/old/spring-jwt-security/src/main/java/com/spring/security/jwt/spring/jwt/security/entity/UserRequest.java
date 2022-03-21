package com.spring.security.jwt.spring.jwt.security.entity;

import lombok.Data;

@Data
public class UserRequest {

	private String username;	
	private String password;
}