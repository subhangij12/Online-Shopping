package com.example.service;

import java.util.List;

import com.example.data.Product;


public interface ProductService {
	public Product getProductById(int pId);
	public List<Product> getProductBySearch(String keyword);
	public List<Product> sortProduct(String by, int order);
	public List<Product> filterProduct(String brand, int s, int e);
}
