package com.imr.learning.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imr.learning.jpa.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
