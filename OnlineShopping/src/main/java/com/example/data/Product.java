package com.example.data;

public class Product {
	private String pImage1;
	private String pImage2;
	private String pDescription;
	private int pId;
	private String pName;
	private String pBrand;
	private int pPrice;
	
	public String getpImage2() {
		return pImage2;
	}
	public void setpImage2(String pImage2) {
		this.pImage2 = pImage2;
	}
	
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
	public Product(String pImage1, String pImage2,String pDescription,int pId, String pName, String pBrand, int pPrice) {
		super();
		this.pImage1 = pImage1;
		this.pImage2 = pImage2;
	
		this.pDescription = pDescription;
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
	}
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
}
