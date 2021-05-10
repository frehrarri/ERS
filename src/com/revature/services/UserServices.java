package com.revature.services;

import java.util.List;

import com.revature.models.Users;

import com.revature.repos.UsersDAOImpl;

public class UserServices {

	private static UsersDAOImpl uDao = new UsersDAOImpl();

	public Users login(Users user) {
		Users userFromDB = uDao.getUserByUsername(user.getUsername());

		if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
			return userFromDB;
		} else {
			return null;
		}
	}
	
	public Users getByUser(String username) {
		System.out.println(username);
		Users userFromDB = uDao.getUserByUsername(username);
		return userFromDB;
	}

}
