package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementDAOImpl;

public class ReimbursementService {
		
	Reimbursement req = new Reimbursement();
	
		private static ReimbursementDAOImpl rDao = new ReimbursementDAOImpl();

		public List<Reimbursement> getPendingRequests() {
			return rDao.pendingRequests();
		}
		
		public List<Reimbursement> getCompletedRequests() {
			return rDao.completedRequests();
		}
		
		public String updateRequestStatusSvc(String refundStatusId) {
			req.setRefundStatusId(refundStatusId);
			return req.getRefundStatusId();
		}
		
		public boolean addNewRequest(Reimbursement reimb) {
			if(rDao.submitNewRequest(reimb)) {
				return true;
			}
			return false;
		}

		
	}


	
