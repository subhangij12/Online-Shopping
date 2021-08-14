package com.example.repository;


import java.util.List;


import com.example.data.Cart;
import com.example.data.PlacedOrder;

public interface PlaceOrderDAO {
	public boolean placeOrder(List<Cart> carts, String payType);
	public List<PlacedOrder> showPlacedOrders(int uId);
}
