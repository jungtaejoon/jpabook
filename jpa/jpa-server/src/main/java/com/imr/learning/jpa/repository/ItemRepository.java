package com.imr.learning.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imr.learning.jpa.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	public List<Item> findByName(String name);

}
