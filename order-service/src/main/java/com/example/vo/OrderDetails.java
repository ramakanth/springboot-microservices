package com.example.vo;

public class OrderDetails {
	
	private int orderId;
	private String customerName;
	private String productName;
	
	public OrderDetails(int orderId, String customerName, String productName) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.productName = productName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
