package com.example.util;

import java.util.ArrayList;
import java.util.List;

import com.example.vo.Customer;

public class CustomerUtil {
	
	public static List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(100, "Ramakanth","Dhane"));
		customers.add(new Customer(200, "Uday","Singh"));
		customers.add(new Customer(300, "Rajesh", "Gajjala"));
		customers.add(new Customer(400, "Nagarjuna","Pothireddy"));
		customers.add(new Customer(500, "Harsha","Kancharla"));
		return customers;
	}
	
	

}
