/*
 * @Author : Ramakanth D
 * 
 * */
package com.example.util;

import java.util.ArrayList;
import java.util.List;

import com.example.vo.Customer;
import com.example.vo.Order;
import com.example.vo.OrderDetails;


public class OrderUtil {
	public static List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(11, 100,"Laptop"));
		orders.add(new Order(22, 300, "keyboard"));
		orders.add(new Order(33, 100, "Mouse"));
		orders.add(new Order(44, 400, "Monitor"));
		orders.add( new Order(55, 200, "Head Phones"));
		return orders;
	}
	public static List<Order> getOrderByCustomerId(int customerId) {
		List<Order> ordersList = new ArrayList<>();
		List<Order> orders = getOrders();
		for (Order order : orders) {
			if(order.getCustomerId() == customerId) {
				ordersList.add(order);
			}
		}
		return ordersList;
      
    }
	public static OrderDetails getOrderDetailsByCustomerId(Customer customer) {
		List<Order> orders = getOrders();
		for (Order order : orders) {
			if(order.getCustomerId() == customer.getCustomerId()) {
				return new OrderDetails(order.getOrderId(), customer.getFirstName()+" "+customer.getLastName(), order.getProductName());
			}
		}
		return null;
      
    }
	
	

}
