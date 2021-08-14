package com.example.service;

import java.util.List;

import com.example.data.Cart;
import com.example.data.PlacedOrder;
import com.example.exception.CartException;


import com.example.pojo.CartTable;
import com.example.pojo.UserTable;

public interface CustomerService {
	
	public List<Cart> getCartValues(int uId); 

	public boolean addToCart(int uId, int pId);
	
	public boolean deleteCart(int cId) throws CartException;
	
	public UserTable getUserById(int uId); //only for testing purpose
	public boolean updateCart(int cId, int addOrMinus);
	
	
}


