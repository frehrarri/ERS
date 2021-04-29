package com.revature.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UsersDAOImpl implements UsersDAO{
	
	Users user = new Users();
	
	public Users getUserByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";

			// The prepared statement object will run a query against the database with an open
			// connection. It will protect against SQL injection.
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);


			ResultSet result = statement.executeQuery();

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Users user = new Users();
				user.setUsername(result.getString("ers_username"));
				user.setPassword(result.getString("ers_password"));
				user.setRole(result.getInt("user_role_id"));
				return user;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
