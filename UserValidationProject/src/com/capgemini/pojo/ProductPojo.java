package com.capgemini.pojo;

public class ProductPojo {
	private String productId;
	private String productName;
	private double productPrice;
	public ProductPojo(String productId, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "ProductPojo [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice + "]";
	}
	

}
