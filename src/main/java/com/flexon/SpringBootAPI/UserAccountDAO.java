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
	ArrayList<UserAccount> javaClass2 = new ArrayList<UserAccount>();
	
	// Create Method --> Insert statement
	public void createUser() {
		Connection conn = cu.getConnection();
		String sqlCreateMethod = "insert into bankDB.Users (firstName, lastName, phoneNumber, ssn) "
				+ "values ('Jerome', 'Zhang', '1234567', '123456789')";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlCreateMethod);
			prepStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
		
	// Read Method --> Select statement
	public ArrayList<UserAccount> readUsers() {
		Connection conn = cu.getConnection();
		String sqlReadMethod = "select * from bankDB.Users";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlReadMethod);
			ResultSet results = prepStatement.executeQuery();
			javaClass2.clear();
			while (results.next()) {
				UserAccount currentStudent = new UserAccount();
				int KeyID = results.getInt("keyID");
				currentStudent.setKeyID(KeyID);
				String firstName = results.getString("firstName");				
				currentStudent.setFirstName(firstName);
				String lastName = results.getString("lastName");
				currentStudent.setLastName(lastName);
				int phoneNumber = results.getInt("phoneNumber");
				currentStudent.setPhoneNumber(phoneNumber);
				int ssn = results.getInt("ssn");
				currentStudent.setSsn(ssn);
				javaClass2.add(currentStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return javaClass2;
	}

	// Read Method --> Select from where statement
	public ArrayList<UserAccount> readUser(int keyID) {
		Connection conn = cu.getConnection();
		String sqlReadMethod = "select * from bankDB.Users where keyID = ?";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlReadMethod);
			prepStatement.setInt(1, keyID);
			ResultSet results = prepStatement.executeQuery();
			javaClass2.clear();
			UserAccount currentStudent = new UserAccount();
			while (results.next()) {
				int KeyID = results.getInt("keyID");
				currentStudent.setKeyID(KeyID);
				String firstName = results.getString("firstName");				
				currentStudent.setFirstName(firstName);
				String lastName = results.getString("lastName");
				currentStudent.setLastName(lastName);
				int phoneNumber = results.getInt("phoneNumber");
				currentStudent.setPhoneNumber(phoneNumber);
				int ssn = results.getInt("ssn");
				currentStudent.setSsn(ssn);
				javaClass2.add(currentStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return javaClass2;
	}

	// Update Method --> Update SQL statement
	public void updateUser(String Name, int keyID) {
		Connection conn = cu.getConnection();
		String sqlReadMethod = "update bankDB.Users set firstName = ? where keyID = ?";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlReadMethod);
			prepStatement.setString(1, Name);
			prepStatement.setInt(2, keyID);
			prepStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	// Delete Method --> Delete SQL statement
	public void deleteUser(int keyID) {
		Connection conn = cu.getConnection();
		String sqlReadMethod = "delete from bankDB.Users where keyID = ?";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlReadMethod);
			prepStatement.setInt(1, keyID);
			prepStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
}