package com.flexon.SpringBootAPI;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
	
	@Autowired
	UserAccountDAO userDAO = new UserAccountDAO();
	
	@GetMapping(path="/studentDetails")
	public ArrayList<UserAccount> orderDetails() {
		return userDAO.readUsers();
	}
	
	@GetMapping(path="/studentDetails/{studentName}")
	@ResponseStatus(code = HttpStatus.OK)
	public void getStudentDetails(@PathVariable String studentName) {
		
	}
	
	@GetMapping(path="/hello")
	public String hello() {
		return "This is Deep and its not in JSON format";
		
	}
	
	@PostMapping(path="/createNewStudent")
	public String createNewUser(@RequestBody UserAccount newUser) {
		userDAO.createUser(newUser);
		return "User added - " + newUser.getFirstName();
	}


}