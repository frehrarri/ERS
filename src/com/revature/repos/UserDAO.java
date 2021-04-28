package com.revature.repos;

import java.util.List;

import com.revature.models.Employees;

public interface EmployeeDAOs {

	public Employees getUserByUsername(String username);
	public List<Employees> pendingRequests();
	public List<Employees> completedRequests();
	public boolean submitNewRequest(Employees em);
	
}