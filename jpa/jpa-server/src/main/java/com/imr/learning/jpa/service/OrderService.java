package com.imr.learning.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Delivery;
import com.imr.learning.jpa.domain.Member;
import com.imr.learning.jpa.domain.Order;
import com.imr.learning.jpa.domain.OrderItem;
import com.imr.learning.jpa.domain.OrderStatus;
import com.imr.learning.jpa.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	public Order findOne(Long id) {
		return repository.findOne(id);
	}
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public void createOrder(Member member, Delivery delivery, List<OrderItem> orderItems) {
		Order order = new Order(member, delivery, orderItems);
		repository.save(order);
	}
	
	public void updateOrderItems(Long id, List<OrderItem> orderItems) {
		Order foundOrder = findOne(id);
		foundOrder.setOrderItems(orderItems);
	}
	
	public void updateDelivery(Long id, Delivery delivery) {
		Order foundOrder = findOne(id);
		foundOrder.setDelivery(delivery);
	}
	
	public void cancelOrder(Long id) {
		Order foundOrder = findOne(id);
		foundOrder.setStatus(OrderStatus.CANCEL);
	}
	
	public int getTotalPrice(Long id) {
		Order foundOrder = findOne(id);
		List<OrderItem> foundOrderItems = foundOrder.getOrderItems();
		int total = 0;
		for(OrderItem orderItem : foundOrderItems) {
			total += orderItem.getOrderPrice();
		}
		return total;
	}
}
