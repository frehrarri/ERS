package com.revature.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UsersDAOImpl implements UsersDAO {

	Users user = new Users();

	public Users getUserByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?;";

			// The prepared statement object will run a query against the database with an
			// open
			// connection. It will protect against SQL injection.
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
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

	public List<Users> getAllUsers(){
			try (Connection conn = ConnectionUtil.getConnection()) {

				String sql = "SELECT * FROM ers_users ORDER BY ers_users_id DESC;";
				//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id != 1 AND ers_user_role_id = 2;";

				// The statement object will run a query against the database with an open
				// connection.x
				Statement statement = conn.createStatement();

				List<Users> list = new ArrayList<>();

				// The statement executes the query that we wrote and returns the response in a
				// ResultSet object.
				ResultSet result = statement.executeQuery(sql);

				// This will go through each result and get the info for the home, adding it to
				// the list.
				while (result.next()) {
					Users userInfo = new Users(
							result.getString("ers_username"),
							result.getString("user_first_name"),
							result.getString("user_last_name"),
							result.getString("user_email"), 
							result.getInt("user_role_id"));

					list.add(userInfo);
				}

				return list;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

}
