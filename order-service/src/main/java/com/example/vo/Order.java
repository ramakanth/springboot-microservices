package com.example.vo;

public class Order {
	
	private int orderId;
	private int customerId;
	private String productName;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Order(int orderId, int customerId, String productName) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productName = productName;
	}
}
