package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	public List<Reimbursement> pendingRequests();
	public List<Reimbursement> completedRequests();
	public void updateRequestStatus(int refundStatusId);
	public boolean submitNewRequest(Reimbursement reimb);
}
