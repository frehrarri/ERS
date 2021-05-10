package com.revature.repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.ReimbursementService;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public Users getUserByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?;";

			// The prepared statement object will run a query against the database with an
			// open
			// connection. It will protect against SQL injection.
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Users user = new Users();
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> allPendingRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 AND ers_user_role_id = 1;";
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1;";

			// The statement object will run a query against the database with an open
			// connection.
			Statement statement = conn.createStatement();

			List<Reimbursement> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Reimbursement req = new Reimbursement(
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"), 
						result.getDate("reimb_resolved"),
						result.getString("reimb_description"),
						result.getInt("reimb_author"), 
						result.getInt("reimb_resolver"),
						result.getInt("reimb_status_id"), 
						result.getInt("reimb_type_id"),
						result.getInt("reimb_id"));

				list.add(req);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> usersPendingRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 AND ers_user_role_id = 2;";
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1;";
			
			// The statement object will run a query against the database with an open
			// connection.
			Statement statement = conn.createStatement();

			List<Reimbursement> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Reimbursement req = new Reimbursement(
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"), 
						result.getDate("reimb_resolved"),
						result.getString("reimb_description"),
						result.getInt("reimb_author"), 
						result.getInt("reimb_resolver"),
						result.getInt("reimb_status_id"), 
						result.getInt("reimb_type_id"),
						result.getInt("reimb_id"));

				list.add(req);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> allCompletedRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id != 1;";
			//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id != 1 AND ers_user_role_id = 1;";

			// The statement object will run a query against the database with an open
			// connection.x
			Statement statement = conn.createStatement();

			List<Reimbursement> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Reimbursement req = new Reimbursement(
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"), 
						result.getDate("reimb_resolved"),
						result.getString("reimb_description"),
						result.getInt("reimb_author"), 
						result.getInt("reimb_resolver"),
						result.getInt("reimb_status_id"), 
						result.getInt("reimb_type_id"),
						result.getInt("reimb_id"));

				list.add(req);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> userCompletedRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id != 1;";
			//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id != 1 AND ers_user_role_id = 2;";

			// The statement object will run a query against the database with an open
			// connection.x
			Statement statement = conn.createStatement();

			List<Reimbursement> list = new ArrayList<>();

			// The statement executes the query that we wrote and returns the response in a
			// ResultSet object.
			ResultSet result = statement.executeQuery(sql);

			// This will go through each result and get the info for the home, adding it to
			// the list.
			while (result.next()) {
				Reimbursement req = new Reimbursement(
						result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"), 
						result.getDate("reimb_resolved"),
						result.getString("reimb_description"),
						result.getInt("reimb_author"), 
						result.getInt("reimb_resolver"),
						result.getInt("reimb_status_id"), 
						result.getInt("reimb_type_id"),
						result.getInt("reimb_id"));

				list.add(req);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRequestStatus(int refundStatusId) {
		ReimbursementService rs = new ReimbursementService();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE ers_reimbursement SET reimbursement_status = "
					+ rs.updateRequestStatusSvc(refundStatusId) + " WHERE reimb_status_id  = 1;";
			Statement statement = conn.createStatement();
			statement.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean submitNewRequest(Reimbursement reimb) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, reimb.getRefundAmount());
			statement.setDate(++index, reimb.getRefundRequestedDate());
			statement.setDate(++index, reimb.getRefundResolvedDate());
			statement.setString(++index, reimb.getRefundDescription());
			statement.setInt(++index, reimb.getRefundAuthor());
			statement.setNull(++index, Types.INTEGER);
			statement.setInt(++index, reimb.getRefundStatusId());
			statement.setInt(++index, reimb.getRefundType());

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
