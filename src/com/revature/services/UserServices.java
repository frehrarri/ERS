package com.revature.services;

import com.revature.models.Users;
import com.revature.repos.UsersDAOImpl;

public class UserServices {
		
		private static UsersDAOImpl uDao = new UsersDAOImpl();
		
		public boolean login(Users user) {
			Users userFromDB = uDao.getUserByUsername(user.getUsername());
			if(userFromDB!=null && userFromDB.getPassword().equals(user.getPassword())) {
				return true;
			}
			return false;
		}
	
		
	}

	

