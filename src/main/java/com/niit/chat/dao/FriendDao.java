package com.niit.chat.dao;

import java.util.List;

import com.niii.chat.model.Friend;



public interface FriendDao {

	void addFriend(Friend friend);
	void updateFriend(Friend friend);
	void deleteFriend(Friend friend);
	List<Friend> viewFriends(String name);
	
}