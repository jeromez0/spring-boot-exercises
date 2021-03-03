package com.flexon.SpringBootAPI;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class UserAccountDAO {

	ArrayList<String> javaClass = new ArrayList<String>();
	ConnSingleton cu = ConnSingleton.getConnSingleton();
		
	//Read Method  --> Select statement
	public ArrayList<String> readUsers() {
		Connection conn = cu.getConnection();
		String sqlReadMethod = "select * from bankDB.Users"; 
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlReadMethod);
			ResultSet results = prepStatement.executeQuery();
			int counter = 0;
			javaClass.clear();
			while (results.next()) { 
				String name = results.getString("firstName");
				javaClass.add(name);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return javaClass;
	}
	
	//Create Method  --> Insert statement
	public void createUser() {		
		Connection conn = cu.getConnection();
		String sqlCreateMethod = "insert into bankDB.Users (firstName, lastName, phoneNumber, ssn) " + 
		"values ('Jerome', 'Zhang', '1234567', '123456789')"; 		
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlCreateMethod);
			prepStatement.execute();			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	//Read Method  --> Select from where statement
	public void readUser(String name) {

	}
	
	//Update Method   --> Update SQL statement
	public void updateUser(UserAccount newUser) {
//		javaClass.add(newUser);
	}
	
	//Delete Method  --> Delete SQL statement
	public void deleteUser(UserAccount newUser) {
//		javaClass.remove(newUser);
	}
	
	
}