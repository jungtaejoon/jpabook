package com.imr.learning.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Order;
import com.imr.learning.jpa.domain.OrderItem;
import com.imr.learning.jpa.domain.OrderStatus;
import com.imr.learning.jpa.domain.item.Item;
import com.imr.learning.jpa.repository.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	OrderItemRepository repository;
	
	@Autowired
	ItemService itemService;

	public void saveOrderItem(OrderItem orderItem) {
		repository.save(orderItem);
	}

	public OrderItem findOrderItem(Long id) {
		return repository.findOne(id);
	}

	public List<OrderItem> findAllOrderItem() {
		return repository.findAll();
	}

	public OrderItem createOrderItem(Order order, Item item, int count) throws NotEnoughStockException {
		OrderItem orderItem = new OrderItem(order, item, count);
		itemService.calStock(-count, item);
		return repository.save(orderItem);
	}
	
	public void cancelOrderItem(List<OrderItem> orderItems) throws NotEnoughStockException {
		for(OrderItem orderItem : orderItems) {
			Item item = orderItem.getItem();
			int count = orderItem.getCount();
			itemService.calStock(count, item);
			Order order = orderItem.getOrder();
			order.setStatus(OrderStatus.CANCEL);
		}
	}
	
}
