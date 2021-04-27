package com.revature.repos;

import java.util.List;

import com.revature.models.Managers;

public interface ManagerDAOs {
	
	public Managers getUserByUsername(String username);
	public List<Managers> pendingRequests();
	public List<Managers> completedRequests();
	public void updateRequestStatusApproved();
	public void updateRequestStatusDenied();
}
