package com.revature.models;

import java.sql.Date;

public class Users {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private static int role;
	
	public Users(String username, String password, String firstName, String lastName, String email, int role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Users.role = role;
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Users() {
	}

	
	public Users(String username, String firstName, String lastName, String email, int role) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getRole() {
		return role;
	}

	public void setRole(int role) {
		Users.role = role;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	public String getLastName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}
	

}
