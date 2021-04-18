package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException{
		
	//makes java aware of our database driver
	try {
		Class.forName("org.postgresql.Driver");
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	String url ="";
	String user ="";
	String pass ="";
	
	//creates our connection to our database
	return DriverManager.getConnection(url, user, pass);


	}
	
}
