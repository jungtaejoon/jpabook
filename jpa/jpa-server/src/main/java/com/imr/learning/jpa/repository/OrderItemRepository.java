package com.imr.learning.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imr.learning.jpa.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
