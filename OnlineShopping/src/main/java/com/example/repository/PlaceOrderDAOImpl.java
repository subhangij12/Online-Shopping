//package com.example.repository;
//
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Repository;
//
//import com.example.data.Cart;
//import com.example.data.PlacedOrder;
//import com.example.pojo.CartTable;
//import com.example.pojo.OrderDetailTable;
//import com.example.pojo.OrderTable;
//import com.example.pojo.PaymentTable;
//import com.example.pojo.ProductTable;
//import com.example.pojo.UserTable;
//
//
//@Repository
//public class PlaceOrderDAOImpl implements PlaceOrderDAO {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@Override
//	@Transactional
//	public boolean placeOrder(List<Cart> carts, String payType) {
//		// TODO Auto-generated method stub
//		//first get productTable, userTable from a specific Cart
//		List<OrderDetailTable> orderDetailTables = new ArrayList<OrderDetailTable>();
//		OrderTable newOrder = null;
//		CartTable actualCart = null;
//		UserTable user = null;
//		actualCart = this.entityManager.find(CartTable.class, carts.get(0).getcId());
//		user = actualCart.getUserTable();
//		
//		newOrder = new OrderTable();
//		Date yourDate = new Date(); 
//		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
//		String date = DATE_FORMAT.format(yourDate);                  
//		newOrder.setUserTable(user);
//		this.entityManager.persist(newOrder); //save the order now get orderId
//		for(Cart c : carts)
//		{
//			actualCart = this.entityManager.find(CartTable.class, c.getcId());
//			// save orderDetails first
////			if(actualCart.getCQty()==0) continue;
//			System.out.println("new date"+ new Date());
//			OrderDetailTable orderDetails = new OrderDetailTable();
//			orderDetails.setOdDelieveryDate(date);   
//			
//			orderDetails.setOdPurchaseDate(new Date());
//			orderDetails.setOdPrice(actualCart.getProductTable().getPPrice());
//			
//			orderDetails.setOdQty(actualCart.getCQty());  
//			orderDetails.setOrderTable(newOrder);
//			orderDetails.setProductTable(actualCart.getProductTable());
//			this.entityManager.persist(orderDetails); //adding new OrderDetailsTable
//			orderDetailTables.add(orderDetails); //this list is used by newOrder
//			//now update ProductTable pQty!
//			ProductTable product = actualCart.getProductTable();
//			int actualProductQty = product.getPQty();
//			int newProductQty = actualProductQty - actualCart.getCQty();
//			product.setPQty(newProductQty); 
//			this.entityManager.merge(product); //updating Product qty
//			this.entityManager.remove(actualCart); //remove from cart as well
//		}
//		PaymentTable newPayment = new PaymentTable();
//		newPayment.setPayType(payType); //setOrderTable pending!
//		this.entityManager.persist(newPayment); //adding new Payment
//		newOrder.setOrderDetailTables(orderDetailTables);
//		newOrder.setPaymentTable(newPayment);
//		this.entityManager.merge(newOrder); //update final OrderTable
//		return true;
//	}
//	
//	@Override
//	public List<PlacedOrder> showPlacedOrders(int uId)
//	{
//		String pType = "";
//		List<PlacedOrder> orders = new ArrayList<PlacedOrder>();
//		UserTable user = this.entityManager.find(UserTable.class, uId);
//		String q = "from OrderTable where userTable=:x";
//		Query query = (Query) this.entityManager.createQuery(q);
//		query.setParameter("x", user);
//		List<OrderTable> myOrders = query.getResultList();
//		if(myOrders.size()!=0)
//		{
//			
//			pType = myOrders.get(0).getPaymentTable().getPayType();
//		}
//		for(OrderTable oye : myOrders)
//		{
//			q = "from OrderDetailTable where orderTable=:y";
//			query = (Query)this.entityManager.createQuery(q);
//			query.setParameter("y", oye);
//			List<OrderDetailTable> orderDetailTables = query.getResultList();
//			for(OrderDetailTable o : orderDetailTables)
//			{
//				String pName = o.getProductTable().getPName();
//				int pId = o.getProductTable().getPId();
//				String pImage = o.getProductTable().getPImage1();
//				String pBrand = o.getProductTable().getPBrand();
//				int pPrice = o.getOdPrice();
//				int pQty = o.getOdQty();
//				String pOrderDate = o.getOdPurchaseDate().toString();
//				orders.add(new PlacedOrder(pName,pId, pImage, pBrand, pPrice, pOrderDate,pQty,pType));
//			}
//		}
//		return orders;
//	}
//
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}