package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.Product;
import com.example.pojo.ProductTable;
import com.example.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public Product getProductById(int pId) {
		// TODO Auto-generated method stub
		return this.productDAO.getProductById(pId);
	}

	@Override
	public List<Product> getProductBySearch(String keyword) {
		// TODO Auto-generated method stub
		return this.productDAO.getProductBySearchKeyWord(keyword);
	}

	@Override
	public List<Product> sortProduct(String by, int order) {
		// TODO Auto-generated method stub
		return this.productDAO.sortProduct(by, order);
	}

	@Override
	public List<Product> filterProduct(String brand, int startingPrice, int endingPrice) {
		// TODO Auto-generated method stub
		return this.productDAO.filterProduct(brand, startingPrice, endingPrice);
	}
}
