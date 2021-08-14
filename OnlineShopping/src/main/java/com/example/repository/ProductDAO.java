package com.example.repository;

import java.util.List;

import com.example.data.Product;
import com.example.pojo.ProductTable;

public interface ProductDAO {
	public Product  getProductById(int pId);
	public List<Product> getProductBySearchKeyWord(String keyword);
	public List<Product> sortProduct(String by, int order);
	public List<Product> filterProduct(String brand, int s, int e);
}
