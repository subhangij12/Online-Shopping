package com.example.pojo;

import java.io.Serializable;
import javax.persistence.*;



import java.util.List;


/**
 * The persistent class for the PRODUCT_TABLE database table.
 * 
 */
@Entity
@Table(name="PRODUCT_TABLE")

public class ProductTable implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="P_ID")
	private int pId;

	@Column(name="P_BRAND")
	private String pBrand;

	@Column(name="P_CATEGORY")
	private String pCategory;

	@Column(name="P_DESCRIPTION")
	private String pDescription;

	@Column(name="P_IMAGE1")
	private String pImage1;

	@Column(name="P_IMAGE2")
	private String pImage2;


	@Column(name="P_NAME")
	private String pName;

	@Column(name="P_PRICE")
	private int pPrice;

	@Column(name="P_QTY")
	private int pQty;

	@Column(name="p_subcategory")
	private String pSubCategory;

	//bi-directional many-to-one association to CartTable
	@OneToMany(mappedBy="productTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CartTable> cartTables;

	//bi-directional many-to-one association to OrderDetailTable
	@OneToMany(mappedBy="productTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderDetailTable> orderDetailTables;

	//bi-directional many-to-one association to RetailerTable
	@ManyToOne
	@JoinColumn(name="R_ID")
	private RetailerTable retailerTable;

	//bi-directional many-to-one association to WishlistTable
	@OneToMany(mappedBy="productTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<WishlistTable> wishlistTables;

	public ProductTable() {
	}

	public int getPId() {
		return this.pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getPBrand() {
		return this.pBrand;
	}

	public void setPBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getPCategory() {
		return this.pCategory;
	}

	public void setPCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getPDescription() {
		return this.pDescription;
	}

	public void setPDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getPImage1() {
		return this.pImage1;
	}

	@Override
	public String toString() {
		return "ProductTable [pId=" + pId + ", pBrand=" + pBrand + ", pCategory=" + pCategory + ", pDescription="
				+ pDescription + ", pImage1=" + pImage1 + ", pImage2=" + pImage2 
				 + ", pName=" + pName + ", pPrice=" + pPrice + ", pQty=" + pQty + ", pSubCategory="
				+ pSubCategory + "]";
	}

	public void setPImage1(String pImage1) {
		this.pImage1 = pImage1;
	}

	public String getPImage2() {
		return this.pImage2;
	}

	public void setPImage2(String pImage2) {
		this.pImage2 = pImage2;
	}


	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public int getPPrice() {
		return this.pPrice;
	}

	public void setPPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getPQty() {
		return this.pQty;
	}

	public void setPQty(int pQty) {
		this.pQty = pQty;
	}

	public String getPSubCategory() {
		return this.pSubCategory;
	}

	public void setPSubCategory(String pSubCategory) {
		this.pSubCategory = pSubCategory;
	}

	public List<CartTable> getCartTables() {
		return this.cartTables;
	}

	public void setCartTables(List<CartTable> cartTables) {
		this.cartTables = cartTables;
	}

	public CartTable addCartTable(CartTable cartTable) {
		getCartTables().add(cartTable);
		cartTable.setProductTable(this);

		return cartTable;
	}

	public CartTable removeCartTable(CartTable cartTable) {
		getCartTables().remove(cartTable);
		cartTable.setProductTable(null);

		return cartTable;
	}

	public List<OrderDetailTable> getOrderDetailTables() {
		return this.orderDetailTables;
	}

	public void setOrderDetailTables(List<OrderDetailTable> orderDetailTables) {
		this.orderDetailTables = orderDetailTables;
	}

	public OrderDetailTable addOrderDetailTable(OrderDetailTable orderDetailTable) {
		getOrderDetailTables().add(orderDetailTable);
		orderDetailTable.setProductTable(this);

		return orderDetailTable;
	}

	public OrderDetailTable removeOrderDetailTable(OrderDetailTable orderDetailTable) {
		getOrderDetailTables().remove(orderDetailTable);
		orderDetailTable.setProductTable(null);

		return orderDetailTable;
	}

	public RetailerTable getRetailerTable() {
		return this.retailerTable;
	}

	public void setRetailerTable(RetailerTable retailerTable) {
		this.retailerTable = retailerTable;
	}

	public List<WishlistTable> getWishlistTables() {
		return this.wishlistTables;
	}

	public void setWishlistTables(List<WishlistTable> wishlistTables) {
		this.wishlistTables = wishlistTables;
	}

	public WishlistTable addWishlistTable(WishlistTable wishlistTable) {
		getWishlistTables().add(wishlistTable);
		wishlistTable.setProductTable(this);

		return wishlistTable;
	}

	public WishlistTable removeWishlistTable(WishlistTable wishlistTable) {
		getWishlistTables().remove(wishlistTable);
		wishlistTable.setProductTable(null);

		return wishlistTable;
	}

}