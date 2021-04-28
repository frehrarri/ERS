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
	public List<Reimbursement> pendingRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status = 'pending';";

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
				Reimbursement req = new Reimbursement(result.getInt("reimb_id"), result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"), result.getDate("reimb_resolved"),
						result.getString("reimb_author"), result.getString("reimb_resolver"),
						result.getString("reimb_status_id"), result.getString("reimb_type_id"),
						result.getString("reimb_description"));

				list.add(req);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> completedRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status != 'pending';";

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
				Reimbursement req = new Reimbursement(result.getInt("reimb_id"), result.getDouble("reimb_amount"),
						result.getDate("reimb_submitted"), result.getDate("reimb_resolved"),
						result.getString("reimb_author"), result.getString("reimb_resolver"),
						result.getString("reimb_status_id"), result.getString("reimb_type_id"),
						result.getString("reimb_description"));

				list.add(req);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRequestStatus() {
		ReimbursementService rs = new ReimbursementService();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE ers_reimbursement SET reimbursement_status = "
					+ rs.updateRequestStatusSvc(refundStatusId) + " WHERE reimbursement_status  = 'pending';";
			Statement statement = conn.createStatement();
			statement.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean submitNewRequest(Reimbursement reimb) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "BEGIN;" + "INSERT INTO ers_reimbursement_status (reimb_status)" + "VALUES(?);"
					+ "INSERT INTO ers_reimbursement_type (reimb_type)" + "	VALUES (?);"
					+ "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);" + "COMMIT;";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, reimb.getRefundAmount());
			statement.setDate(++index, reimb.getRefundRequestedDate());
			statement.setDate(++index, reimb.getRefundResolvedDate());
			statement.setString(++index, reimb.getRefundDescription());
			statement.setString(++index, reimb.getRefundAuthor());
			statement.setString(++index, reimb.getRefundResolver());
			statement.setString(++index, reimb.getRefundStatusId());
			statement.setString(++index, reimb.getRefundType());

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
