package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.exception.CartException;
import com.example.pojo.CartTable;
import com.example.pojo.ProductTable;
import com.example.pojo.UserTable;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean addToCart(int uId, int pId)    
	{
		UserTable user = 	   this.entityManager.find(UserTable.class, uId);
		ProductTable product = this.entityManager.find(ProductTable.class, pId);
		
		CartTable cart = new CartTable();
		
		cart.setCQty(1); //by default set qty as 1
		cart.setUserTable(user);
		cart.setProductTable(product);
		this.entityManager.persist(cart);
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateCart(int cId, int addOrMinus)//updation by quantity
	{
		if(addOrMinus==1)//ADD
		{
			CartTable cart = this.entityManager.find(CartTable.class, cId);//find the cart
			int productQty = cart.getProductTable().getPQty();//get its actual/total product quantity from product table
			if(cart.getCQty()+1 <= productQty) //check if updated or after addition cart quantity of an item should not exceed total item quantity 
			{
				//update it!
				int oldQty = cart.getCQty(); 
				int newQty = oldQty+1;
				cart.setCQty(newQty);
				this.entityManager.merge(cart);
				return true;
			}
			return false;
		}
		else
		{    //subtract
			CartTable cart = this.entityManager.find(CartTable.class, cId);
			if(cart.getCQty()-1 >= 1)//check if minium quantity of an item should be 1 ,while subtracting/removing item quantity it should not go below 1
			{
				//update it!
				int oldQty = cart.getCQty();
				int newQty = oldQty-1;
				cart.setCQty(newQty);
				this.entityManager.merge(cart);
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean deleteCart(int cId) throws CartException
	{
		CartTable cart = this.entityManager.find(CartTable.class, cId);//find the cart
		this.entityManager.remove(cart);
		return true;
	}
	
}
