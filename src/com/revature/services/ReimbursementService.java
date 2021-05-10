package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementDAOImpl;
import com.revature.models.Users;

public class ReimbursementService {

	Reimbursement req = new Reimbursement();

	private static ReimbursementDAOImpl rDao = new ReimbursementDAOImpl();

	public List<Reimbursement> getAllPendingRequests() {
		return rDao.allPendingRequests();
	}
	
	public List<Reimbursement> getUserPendingRequests() {
		return rDao.usersPendingRequests();
	}

	public List<Reimbursement> getUserCompletedRequests() {
		return rDao.userCompletedRequests();
	}

	public List<Reimbursement> getAllCompletedRequests() {
		return rDao.allCompletedRequests();
	}
	
	public int updateRequestStatusSvc(int refundStatusId) {
		if (Users.getRole() == 1) {
			req.setRefundStatusId(refundStatusId);
			return req.getRefundStatusId();
		}
		return 0;
	}

	public boolean addNewRequest(Reimbursement reimb) {
		if (Users.getRole() == 2) {
			if (rDao.submitNewRequest(reimb)) {
				return true;
			}
			return false;
		}
		return false;
	}

}
