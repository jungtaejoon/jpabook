package com.imr.learning.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.OrderItem;
import com.imr.learning.jpa.repository.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	OrderItemRepository repository;

	public void saveItem(OrderItem item) {
		repository.save(item);
	}

	public OrderItem findItem(Long id) {
		return repository.findOne(id);
	}

	public List<OrderItem> findAllItem() {
		return repository.findAll();
	}

	
	
}
