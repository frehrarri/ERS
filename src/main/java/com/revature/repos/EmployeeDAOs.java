package com.revature.repos;

import java.util.List;

public interface EmployeeDAOs {

	public List<Employees> pendingRequests();
	public List<Employees> completedRequests();
	public boolean submitNewRequest(Employees em);
	
}
