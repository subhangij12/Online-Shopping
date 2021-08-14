package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Cart;
import com.example.data.PlacedOrder;
import com.example.data.Product;
import com.example.pojo.UserTable;

import com.example.service.CustomerService;
import com.example.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/main")
public class MainController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/index") // passed http://localhost:8090/index
	public String home() {
		return "Welcome";
	}

//------------------------------------------------CART--> 1.GET CART 2.ADD TO CART 3. UPDATE CART 4. DELETE FROM CART---------------------------
	
//1.GET CART ITEM OF PARTICULAR USER:---
	
	@GetMapping(path = "/getMyCart/{uId}")
	public List<Cart> getMyCart(@PathVariable String uId) {
		return this.customerService.getCartValues(Integer.parseInt(uId));
	}

//	http://localhost:8090/main/getMyCart/305
//	user/customer-301

//	2. ADD PRODUCT TO CART OF A USER:---
	
	@GetMapping(path = "/addToMyCart/{uId}/{pId}")
	public String addToMyCart(@PathVariable String uId, @PathVariable String pId) {
		boolean ok = this.customerService.addToCart(Integer.parseInt(uId), Integer.parseInt(pId));
		if (ok == true)
			return "Product Added to Cart Successfull";
		return "Cannot Add Product to Cart";
	}

//	http://localhost:8090/main/addToMyCart/301/416
//user-301   product-401	
// add product to cart using user id and product id

//	3. UPDATE CART BY ADDING OR SUBTRACTING A PRODUCT FROM IT :-----
	
//	BY DEFAULT MIN PRODUCT AVAILABLE SHOULD BE 1
//	PRODUCT QUANTITY in cart should not exceed actual product quantity in product table

	@GetMapping(path = "/updateMyCart/{cId}/{addOrMinus}") //passed
	public String updateMyCart(@PathVariable String cId, @PathVariable String addOrMinus)
	{
		boolean ok = this.customerService.updateCart(Integer.parseInt(cId),Integer.parseInt(addOrMinus));
		if(ok==true)
			return "Cart Updated Successfull";
		return "Cannot Update Cart";
	}

//	Add or Subtract quantity of product using cart_id
//	1--> add or increase 0---> minus decrease quantity of a product 
//	http://localhost:8090/main/updateMyCart/800/1
//	http://localhost:8090/main/updateMyCart/800/0

//	4. DELETE A PRODUCT FROM CART USING CART_ID:-----
	
	@DeleteMapping(path = "/deleteMyCart/{cId}")
	public String deleteMyCart(@PathVariable String cId) {
		try {
			boolean ok = this.customerService.deleteCart(Integer.parseInt(cId));
			return "deleted succesfully";

		} catch (Exception e) {
			return "not found";
		}
	}

//	http://localhost:8090/main/deleteMyCart/820
// cart-800	
//delete using cart_id

//------------------------------------------PRODUCT-->1. get product 2.search product 3.sort product 4.filter product -------------------------------

//	1.FETCH PRODUCT USING PRODUCT_ID
	
	@GetMapping(path = "/getProductById/{pId}")
	public Product getProductById(@PathVariable int pId) {
		return this.productService.getProductById(pId);
	}
//	fetch product details using product id
//	http://localhost:8090/main/getProductById/403

//	2.SEARCH PRODUCT
	
	@GetMapping(path = "/getProductBySearch/{pSearch}") // passed
	public List<Product> getProductBySearch(@PathVariable String pSearch) {
		return this.productService.getProductBySearch(pSearch);
	}

//	search bar----> search by product ,brand and category
//	http://localhost:8090/main/getProductBySearch/Apple                         search by brand
//	http://localhost:8090/main/getProductBySearch/Iphone 12                     search by product
//	http://localhost:8090/main/getProductBySearch/Electronics                   search by category

//	3.SORT PRODUCT
	
	@GetMapping(path = "/sortProduct/{by}/{order}") // passed
	public List<Product> sortProduct(@PathVariable String by, @PathVariable String order) {
		return this.productService.sortProduct(by, Integer.parseInt(order));
	}

//	sort product by brand or price
//	1 is for ascending 
//	0 is for descending
//	http://localhost:8090/main/sortProduct/brand/1
//	http://localhost:8090/main/sortProduct/brand/0
//	http://localhost:8090/main/sortProduct/price/0
//	http://localhost:8090/main/sortProduct/price/1

//	4.FILTER PRODUCT
	
	@GetMapping(path = "/filterProduct/{brand}/{startingPrice}/{endingPrice}") // passed
	public List<Product> sortProduct(@PathVariable String brand, @PathVariable String startingPrice,
			@PathVariable String endingPrice) {
		return this.productService.filterProduct(brand, Integer.parseInt(startingPrice), Integer.parseInt(endingPrice));
	}

//	filter product by brand or price range
//	http://localhost:8090/main/filterProduct/Apple/0/0                filtering by brand Apple at price range 0 to 0
//	http://localhost:8090/main/filterProduct/Apple/0/50000

}
