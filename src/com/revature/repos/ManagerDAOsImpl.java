package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employees;
import com.revature.models.Managers;
import com.revature.utils.ConnectionUtil;

public class ManagerDAOsImpl implements ManagerDAOs{
	
	@Override
	public List<Managers> pendingRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status = 'pending';";

			// The statement object will run a query against the database with an open
			// connection.
			Statement statement = conn.createStatement();

			List<Managers> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Managers manager = new Managers(
						result.getInt("reimb_id"),
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"),
						result.getDate("reimb_resolved"), 
						result.getString("reimb_author"),
						result.getString("reimb_resolver"),
						result.getString("reimb_status_id"),
						result.getString("reimb_type_id"),
						result.getString("reimb_description"));
			
				list.add(manager);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Managers> completedRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status != 'pending';";

			// The statement object will run a query against the database with an open
			// connection.
			Statement statement = conn.createStatement();

			List<Managers> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Managers manager = new Managers(
						result.getInt("reimb_id"),
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"),
						result.getDate("reimb_resolved"), 
						result.getString("reimb_author"),
						result.getString("reimb_resolver"),
						result.getString("reimb_status_id"),
						result.getString("reimb_type_id"),
						result.getString("reimb_description"));
			
				list.add(manager);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public void updateRequestStatusApproved() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE ers_reimbursement SET reimbursement_status = 'approved' WHERE reimbursement_status  = 'pending';";
			Statement statement = conn.createStatement();
			statement.execute(sql);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void updateRequestStatusDenied() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE ers_reimbursement SET reimbursement_status = 'denied' WHERE reimbursement_status  = 'pending';";
			Statement statement = conn.createStatement();
			statement.execute(sql);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	
}
