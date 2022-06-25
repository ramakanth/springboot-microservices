/*
 * @Author : Ramakanth D
 * 
 * */
package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.util.OrderUtil;
import com.example.vo.Customer;
import com.example.vo.Order;
import com.example.vo.OrderDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;


@RestController
public class OrderController {

   
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	 
	@GetMapping
    public List<Order> getAllOrders() {
        return OrderUtil.getOrders();
    }
    @GetMapping("/order/{id}")
    public Order orderById(@PathVariable int id) {
        return OrderUtil.getOrders().stream()
                        .filter(order -> order.getOrderId() == id)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
    }
    @GetMapping("/order/customer/{customerId}")
    public List<Order> orderByCustomerID(@PathVariable int customerId) {
        return OrderUtil.getOrderByCustomerId(customerId);
    }
    @GetMapping("/order/orderDetails/customer/{customerId}")
    public OrderDetails orderDetails(@PathVariable int customerId) throws Exception{
    	String serviceURI ="";
    
    	List<ServiceInstance> instances = discoveryClient.getInstances("CUSTOMER-SERVICE");
    	Optional<ServiceInstance> findFirst = instances.stream()
    	        .findFirst();
    	if(findFirst.isPresent()) {
    	    ServiceInstance serviceInstance = findFirst.get();
    	    serviceURI = serviceInstance.getUri()+"/customer/"+customerId;
    	}
    	//String object = restTemplate.exchange("http://localhost:8081/customer/"+customerId,
    	String object = restTemplate.exchange(serviceURI,
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, customerId).getBody();
    	ObjectMapper objectMapper = new ObjectMapper();
    	byte[] bytes = object.getBytes("UTF-8");

    	Customer customer = objectMapper.readValue(bytes, Customer.class);
        return OrderUtil.getOrderDetailsByCustomerId(customer);
    }
    
   


}
