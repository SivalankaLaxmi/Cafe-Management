package com.in.cafe.restControllersImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.restControllers.UserController;
import com.in.cafe.serviceImpl.UserServiceImpl;

@RestController
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserServiceImpl userserviceimpl;

	@Override
	public ResponseEntity<String> signup(Map<String, String> userDetails) {
		ResponseEntity<String> response = null;
		// TODO Auto-generated method stub
		try {
			
			response = userserviceimpl.signup(userDetails);
			System.out.println("The Response is : "+response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
