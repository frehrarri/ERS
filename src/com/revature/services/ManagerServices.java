package com.revature.services;

import java.util.List;

import com.revature.models.Managers;
import com.revature.repos.ManagerDAOsImpl;

public class ManagerServices {
		
		private static ManagerDAOsImpl mDao = new ManagerDAOsImpl();
		
		public boolean login(Managers user) {
			Managers userFromDB = mDao.getUserByUsername(user.getUsername());
			if(userFromDB!=null && userFromDB.getPassword().equals(user.getPassword())) {
				return true;
			}
			return false;
		}

		public List<Managers> getPendingRequests() {
			return mDao.pendingRequests();
		}
		
		public List<Managers> getCompletedRequests() {
			return mDao.completedRequests();
		}
		
	}


	
