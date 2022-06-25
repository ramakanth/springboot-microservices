package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.util.CustomerUtil;
import com.example.vo.Customer;

@RestController
public class CustomerController {
	
	@GetMapping
    public List<Customer> getAllCustomers() {
        return CustomerUtil.getCustomers();
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer cust = CustomerUtil.getCustomers().stream()
                        .filter(customer -> customer.getCustomerId() == id)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
        return cust;
    }

}
