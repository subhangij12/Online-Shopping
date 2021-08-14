package com.example.repository;

import com.example.exception.CartException;

public interface CartDAO {
	public boolean addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId) throws CartException;
}
