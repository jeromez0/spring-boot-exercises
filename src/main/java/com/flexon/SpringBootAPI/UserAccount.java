package com.flexon.SpringBootAPI;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UserAccount implements Serializable {

	@Id
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Column(name = "phoneNumber", nullable = false)
	private int phoneNumber;
	@Column(name = "ssn", nullable = false)
	private int ssn;
	
	private int KeyID;
	
	public UserAccount(int KeyID, String firstName, String lastName, int phoneNumber, int ssn) {
		this.KeyID = KeyID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
	}

	public UserAccount() {
		super();
	}

	public String getFirstName() {
		return firstName.toUpperCase();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getKeyID() {
		return KeyID;
	}

	public void setKeyID(int keyID) {
		KeyID = keyID;
	}
}