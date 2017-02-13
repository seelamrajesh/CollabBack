package com.niit.chat.dao;

import java.util.List;

import com.niii.chat.model.Users;




public interface UsersDao {

	void registerUser(Users user);
	void updateUsers(Users users);
	
	List<Users> listUsers();

	public List<Users> findFriends(String name);
	
	int validateUser(String name, String password);
	void logout(String name);	
}

