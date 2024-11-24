package com.in.cafe.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.cafe.POJO.User;
import com.in.cafe.dao.UserRepository;
import com.in.cafe.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;
	
	@Override
	public ResponseEntity<String> signup(Map<String, String> userDetails) {
		try {
		if(validateResponse(userDetails)) {
			User user = userrepository.findByEmailId(userDetails.get("email"));
			if(Objects.isNull(user)) {
				userrepository.save(getUserDetails(userDetails));
				return new ResponseEntity<>("User Saved Successfully", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("User already existed", HttpStatus.FORBIDDEN);
			}
		}else {
			return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
		}
		}catch(Exception ex) {
			ex.printStackTrace();}
		return new ResponseEntity<>("User created", HttpStatus.CREATED);
	}
	
	public User getUserDetails(Map<String, String> userDetails) {
		User user = new User();
		user.setName(userDetails.get("name"));
		user.setContactNumber(userDetails.get("contactNumber"));
		user.setEmail(userDetails.get("email"));
		user.setPassword(userDetails.get("password"));
		user.setRole(userDetails.get("role"));
		user.setStatus("false");
		
		return user;
	}
	
	public boolean validateResponse(Map<String, String> userMap) {
		if(userMap.containsKey("name") && userMap.containsKey("contactNumber") && 
				userMap.containsKey("email") && userMap.containsKey("password")) {
			return true;
		}
			return false;
	}

}
