package com.revature.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employees;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAOsImpl implements EmployeeDAOs{
	
	Employees author = new Employees();
	
	private String self = author.getRefundAuthor();
	
	@Override
	public List<Employees> pendingRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status = 'pending' AND reim_author ="+self+";";

			// The statement object will run a query against the database with an open
			// connection.
			Statement statement = conn.createStatement();

			List<Employees> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Employees employee = new Employees(
						result.getInt("reimb_id"),
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"),
						result.getDate("reimb_resolved"), 
						result.getString("reimb_author"),
						result.getString("reimb_resolver"),
						result.getString("reimb_status_id"),
						result.getString("reimb_type_id"),
						result.getString("reimb_description"));
			
				list.add(employee);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Employees> completedRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status != 'pending' AND reim_author="+self+";";

			// The statement object will run a query against the database with an open
			// connection.
			Statement statement = conn.createStatement();

			List<Employees> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Employees employee = new Employees(
						result.getInt("reimb_id"),
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"),
						result.getDate("reimb_resolved"), 
						result.getString("reimb_author"),
						result.getString("reimb_resolver"),
						result.getString("reimb_status_id"),
						result.getString("reimb_type_id"),
						result.getString("reimb_description"));
			
				list.add(employee);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public boolean submitNewRequest(Employees em) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "BEGIN;"
					+ "INSERT INTO ers_reimbursement_status (reimb_status)"
					+ "VALUES(?);"
					+ "INSERT INTO ers_reimbursement_type (reimb_type)"
					+ "	VALUES (?);"
					+ "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, em.getRefundAmount());
			statement.setDate(++index, em.getRefundRequestedDate());
			statement.setDate(++index, em.getRefundResolvedDate());
			statement.setString(++index, em.getRefundDescription());
			statement.setString(++index, em.getRefundAuthor());
			statement.setString(++index, em.getRefundResolver());
			statement.setString(++index, em.getRefundStatusId());
			statement.setString(++index, em.getRefundType());		
			
			statement.execute();
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
