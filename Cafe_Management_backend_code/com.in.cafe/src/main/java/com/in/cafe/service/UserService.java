package com.in.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {
	
	public ResponseEntity<String> signup(Map<String, String> userDetails);

}
