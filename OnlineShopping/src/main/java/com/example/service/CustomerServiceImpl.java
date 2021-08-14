package com.example.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.Cart;
import com.example.data.PlacedOrder;
import com.example.exception.CartException;
import com.example.pojo.UserTable;
import com.example.repository.CartDAO;

import com.example.repository.UserDAO;
import com.example.repository.PlaceOrderDAO;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	


	

	@Override
	public List<Cart> getCartValues(int uId) {
		// TODO Auto-generated method stub
		return this.userDAO.getCartOfUser(uId);
	}


	@Override
	public boolean addToCart(int uId, int pId) {
		// TODO Auto-generated method stub
		return this.cartDAO.addToCart(uId, pId);
	}

	@Override
	public boolean updateCart(int cId, int addOrMinus) {
		// TODO Auto-generated method stub
		return this.cartDAO.updateCart(cId,addOrMinus);
	}
	

	@Override
	public boolean deleteCart(int cId) throws CartException {
		// TODO Auto-generated method stub
		return this.cartDAO.deleteCart(cId);
	}

	@Override
	public UserTable getUserById(int uId) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserById(uId);
	}
	

	
}
