package com.revature.services;

import java.util.List;

import com.revature.models.Employees;
import com.revature.repos.EmployeeDAOsImpl;

public class EmployeeServices {
		
		private static EmployeeDAOsImpl eDao = new EmployeeDAOsImpl();
		
		public boolean login(Employees user) {
			Employees userFromDB = eDao.getUserByUsername(user.getUsername());
			if(userFromDB!=null && userFromDB.getPassword().equals(user.getPassword())) {
				return true;
			}
			return false;
		}
		
		public List<Employees> getPendingRequests() {
			return eDao.pendingRequests();
		}
		
		public List<Employees> getCompletedRequests() {
			return eDao.completedRequests();
		}
		
		public boolean addNewRequest(Employees e) {
			if(eDao.submitNewRequest(e)) {
				return true;
			}
			return false;
		}

	}

	

