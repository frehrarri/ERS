package com.revature.repos;

import com.revature.models.Users;

public interface UsersDAO {

	public Users getUserByUsername(String username);
	
}
