package com.example.repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.data.Product;
import com.example.pojo.ProductTable;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Product getProductById(int pId) {
		// TODO Auto-generated method stub
		Product product = null;
		String q = "select pImage1,pId,pName,pBrand,pPrice,pImage2,pDescription from ProductTable where pId=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", pId);
		List<Object []> pro = query.getResultList();
		for(Object [] p : pro)
		{
			System.out.println("Products :"+p[0]+p[1]+Arrays.toString(p));
			String pImage1 = (String) p[0];
			String pName = 	(String) p[2];
			String pBrand = (String) p[3];
			int pPrice =  Integer.parseInt(String.valueOf(p[4]));
			String pImage2 = (String) p[5];
			
			String pDescription = (String) p[6];
			product = new Product(pImage1,pImage2,pDescription,pId,pName,pBrand,pPrice);
		}
		return product;
		//return this.entityManager.find(ProductTable.class,pId); //for testing
	}

	@Override
	public List<Product> getProductBySearchKeyWord(String keyword) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String query = "from ProductTable where pBrand=:x or pCategory=:x or pName like :y ";
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("x",keyword);
		q.setParameter("y", "%"+keyword+"%");
		List<ProductTable> productTables = q.getResultList();
		for(ProductTable p : productTables)
		{
			int pId = p.getPId();
			String pImage1 = p.getPImage1();
			String pName = p.getPName();
			String pBrand = p.getPBrand();
			int pPrice = p.getPPrice();
			String pImage2 = p.getPImage2();
			
			String pDescription = p.getPDescription();
			products.add(new Product(pImage1,pImage2,pDescription,pId,pName,pBrand,pPrice));
		}
		return products;
	}

	
	@Override
	public List<Product> sortProduct(String by, int order) {
		// TODO Auto-generated method stub
		//1 is for ascending and 0 is for descending
		List<Product> products = new ArrayList<Product>();
		Query query = null;
		if(order==1 && by.equalsIgnoreCase("price"))
		{	
			String commonQuery = "from ProductTable order by pPrice asc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==0 && by.equalsIgnoreCase("price"))
		{
			String commonQuery = "from ProductTable order by pPrice desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==1 && by.equalsIgnoreCase("brand"))
		{
			String commonQuery = "from ProductTable order by pBrand asc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==0 && by.equalsIgnoreCase("brand"))
		{
			String commonQuery = "from ProductTable order by pBrand desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		List<ProductTable> pro = query.getResultList();
		for(ProductTable  p : pro)
		{
			int pId = 		 p.getPId();
			String pImage1 =  p.getPImage1();
			String pName = 	 p.getPName();
			String pBrand =  p.getPBrand();
			int pPrice =  	 p.getPPrice();
			String pImage2 = p.getPImage2();
		
			String pDescription = p.getPDescription();
			products.add(new Product(pImage1,pImage2,pDescription,pId,pName,pBrand,pPrice));
		}
		return products;
	}

	@Override
	public List<Product> filterProduct(String brand, int startingPrice, int endingPrice) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		if(startingPrice==0 && endingPrice==0)
		{
			System.out.println("Filtering By Brand");
			String q = "from ProductTable where pBrand=:x ";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("x", brand);
			List<ProductTable> pro = query.getResultList();
			for(ProductTable  p : pro)
			{
				int pId = 		 p.getPId();
				String pImage1 =  p.getPImage1();
				String pName = 	 p.getPName();
				String pBrand =  p.getPBrand();
				int pPrice =  	 p.getPPrice();
				String pImage2 = p.getPImage2();
				
				String pDescription = p.getPDescription();
				products.add(new Product(pImage1,pImage2,pDescription,pId,pName,pBrand,pPrice));
			}
		}
		else
		{
			System.out.println("Filtering By Range");
			String q = "from ProductTable where pBrand=:z and pPrice between :x and :y ";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("z", brand);
			query.setParameter("x", startingPrice);
			query.setParameter("y", endingPrice);
			List<ProductTable> pro = query.getResultList();
			for(ProductTable  p : pro)
			{
				int pId = 		 p.getPId();
				String pImage1 =  p.getPImage1();
				String pName = 	 p.getPName();
				String pBrand =  p.getPBrand();
				int pPrice =  	 p.getPPrice();
				String pImage2 = p.getPImage2();
				
				String pDescription = p.getPDescription();
				products.add(new Product(pImage1,pImage2,pDescription,pId,pName,pBrand,pPrice));
			}
		}
		return products;
	}

	
	
}
