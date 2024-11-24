package com.in.cafe.restControllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface UserController {
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody Map<String, String> userDetails);

}
