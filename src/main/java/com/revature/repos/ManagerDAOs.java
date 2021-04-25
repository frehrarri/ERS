package com.revature.repos;

public interface ManagerDAOs {
	
	public List<Managers> pendingRequests();
	public List<Managers> completedRequests();
	public boolean updateRequestStatus();
}
