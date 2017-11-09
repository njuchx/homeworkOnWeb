package com.chen.dao;

import com.chen.users.Users;

public class UsersDao {
	//public boolean success;
	public boolean usersLogin(Users user) {
		if ("admin".equals(user.getUsername())&&"123456".equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
