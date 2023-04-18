package com.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.Order;
import com.pms.exception.OrderNotFoundException;
import com.pms.repository.OrderRepository;
import com.pms.service.OrderService;

//implementing all method of OrderService
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository or;

	//saving Order details using save() of jpaRepository
	@Override
	public Order placedOrder(Order order) {
		
		return or.save(order);
		
	}

	//fetching all Order details using findAll() of JpaRepository
	@Override
	public List<Order> getAllOrders() {
		
		return or.findAll();
	}

	//fetching Order details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Order getOrderById(int oid) {
		
		return or.findById(oid).orElseThrow(() -> new OrderNotFoundException("No order exist in table"));
	}

	//deleting Order details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public void deleteOrderById(int oid) {
		
		or.findById(oid).orElseThrow(() -> new OrderNotFoundException("No order exist in table"));
		or.deleteById(oid);
		
	}

	//fetching all Order details using getDname() of JpaRepository
	@Override
	public List<Order> getOname(String oname) {

		return or.getOname(oname);
	}

}
