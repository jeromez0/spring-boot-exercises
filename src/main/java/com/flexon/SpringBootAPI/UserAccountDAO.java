package com.flexon.SpringBootAPI;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserAccountDAO {

	ArrayList<UserAccount> javaClass = new ArrayList<UserAccount>();
	
	
	UserAccountDAO(){
		UserAccount newUser = new UserAccount();
		newUser.setFirstName("Mahipal");
		newUser.setLastName("Smith");
		newUser.setPhoneNumber(1234567);
		newUser.setSsn(1111111);
		javaClass.add(newUser);
		
	}
	
	//Read Method  --> Select statement
	public ArrayList<UserAccount> readUsers() {
		return javaClass;
	}
	
	
	//Create Method  --> Insert statement
	public void createUser(UserAccount newUser) {
		javaClass.add(newUser);
	}
	
	//Read Method  --> Select from where statement
	public void readUser(String name) {

	}
	
	//Update Method   --> Update SQL statement
	public void updateUser(UserAccount newUser) {
		javaClass.add(newUser);
	}
	
	//Delete Method  --> Delete SQL statement
	public void deleteUser(UserAccount newUser) {
		javaClass.remove(newUser);
	}
	
	
}