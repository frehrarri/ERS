package com.revature.repos;

import java.util.List;

import com.revature.models.Users;

public interface UsersDAO {

	public Users getUserByUsername(String username);
	public List<Users> getAllUsers();
}

