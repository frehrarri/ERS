package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	public List<Reimbursement> allPendingRequests();
	public List<Reimbursement> usersPendingRequests();
	public List<Reimbursement> allCompletedRequests();
	public List<Reimbursement> userCompletedRequests();
	public void updateRequestStatus(int refundStatusId);
	public boolean submitNewRequest(Reimbursement reimb);
}
