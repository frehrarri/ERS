package com.revature.models;

import java.sql.Date;

public class Users {
	
	private String username;
	private String password;
	private String role;

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Users() {

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

}
