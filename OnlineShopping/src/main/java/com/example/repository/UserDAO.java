package com.example.repository;

import java.util.List;

import com.example.data.Cart;

import com.example.pojo.UserTable;



public interface UserDAO {
//	public List<UserTable> getAllUsers(); //for testing
	public UserTable getUserById(int uId); //for testing
	
	public UserTable updateUser(long uId, UserTable user);
	public List<Cart> getCartOfUser(int uId);
	
	
}
