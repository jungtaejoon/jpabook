package com.imr.learning.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.item.Item;
import com.imr.learning.jpa.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	ItemRepository repository;

	public void saveItem(Item item) {
		repository.save(item);
	}

	public Item findItem(Long id) {
		return repository.findOne(id);
	}

	public List<Item> findAllItem() {
		return repository.findAll();
	}

	public List<Item> findByName(String name) {
		return repository.findByName(name);
	}

	public void updateStock(Item item) {
		repository.save(item);
	}

	public void incStock(Item item) {
		int amount = item.getStockQuantity();
		++amount;
		item.setStockQuantity(amount);
		updateStock(item);
	}

	public void incStock(Item item, int amount) {
		item.setStockQuantity(amount);
		updateStock(item);
	}

	public void incStock(int amount, Item item) {
		amount = amount + item.getStockQuantity();
		item.setStockQuantity(amount);
		updateStock(item);
	}
}
