package com.pms.service;

import java.util.List;

import com.pms.entity.Order;

//abstract method for performing CRUD on Order entity
public interface OrderService {
	
	//saving details of order entity
	Order placedOrder(Order order);
	
	//getting all details of order
	List<Order> getAllOrders();
	
	//getting details of order based on oid
	Order getOrderById(int oid);
	
	//getting details of order based of oid & delete mentioned details
	void deleteOrderById(int oid);
	
	//getting all details of Order based on Order name
	List<Order> getOname(String oname);

}
