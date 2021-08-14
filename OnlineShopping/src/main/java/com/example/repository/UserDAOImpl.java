package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.data.Cart;
import com.example.pojo.CartTable;
import com.example.pojo.UserTable;




@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	



	@Override
	public List<Cart> getCartOfUser(int uId) {
		// TODO Auto-generated method stub
		
		int totalPrice = 0;
		List<Cart> carts = new ArrayList<Cart>();
		UserTable user = (UserTable)this.entityManager.find(UserTable.class, uId);
		System.out.println("User is :"+user);
		String q = "from CartTable where userTable=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", user);
		
		List<CartTable> cartTables = query.getResultList();
		//System.out.println("Cart values are :"+query.getResultList().toString());
		for(CartTable c : cartTables)
		{
			int cId = c.getCId();
			int pId = c.getProductTable().getPId();
			int cQty = c.getProductTable().getPQty()>=c.getCQty() ? c.getCQty() : 0;
			String pName = c.getProductTable().getPName();
			String pBrand = c.getProductTable().getPBrand();
			int pPrice = c.getProductTable().getPPrice();
			totalPrice += pPrice*cQty;
			String pImage1 = c.getProductTable().getPImage1();
			carts.add(new Cart(pId,cQty,pName,pBrand,pPrice,cId,totalPrice,pImage1));
		}
		return carts;
	}








	@Override
	public UserTable getUserById(int uId) {
		// TODO Auto-generated method stub
		return null;
	}








	@Override
	public UserTable updateUser(long uId, UserTable user) {
		// TODO Auto-generated method stub
		return null;
	}


	


}
