package com.revature.repos;

import java.util.List;

public interface EmployeeDAOs {

	public List<Employees> pendingRequests();
	public List<Employees> completedRequests();
	public Employees findByLastName(String lastName);
	public Employees findById(int id);
	public Employees findByStatus(String status);
	public boolean submitNewRequest();
	
}
