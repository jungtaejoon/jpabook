package com.imr.learning.jpa.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Delivery;
import com.imr.learning.jpa.domain.Member;
import com.imr.learning.jpa.domain.Order;
import com.imr.learning.jpa.domain.OrderItem;
import com.imr.learning.jpa.domain.OrderStatus;
import com.imr.learning.jpa.domain.item.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

	@Autowired
	OrderService service;

	@Test
	public void shouldSave() {

		// given
		Member member = new Member("철수");
		Delivery delivery = new Delivery();
		Item item = new Item("상품1");
		OrderItem orderItem = new OrderItem(item);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem);
		
		// when
		Order savedOrder = service.createOrder(member, delivery, orderItems);

		// then
		assertNotNull(savedOrder.getId());
	}

	@Test
	public void shouldUpdateOrderItems() {

		// given
		Member member = new Member("철수");
		Delivery delivery = new Delivery();
		Item item = new Item("상품1");
		OrderItem orderItem = new OrderItem(item);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem);
		Order savedOrder = service.createOrder(member, delivery, orderItems);
		
		Item item2 = new Item("상품2");
		OrderItem orderItem2 = new OrderItem(item2);
		List<OrderItem> orderItems2 = new ArrayList<>();
		orderItems2.add(orderItem2);
		

		// when
		service.updateOrderItems(savedOrder.getId(), orderItems2);
		
		// then
		assertEquals(service.findOne(savedOrder.getId()).getOrderItems(), orderItems2);

	}

	@Test
	public void shouldUpdateDelivery() {
		
		// given
		Member member = new Member("철수");
		Delivery delivery = new Delivery();
		Item item = new Item("상품1");
		OrderItem orderItem = new OrderItem(item);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem);
		Order savedOrder = service.createOrder(member, delivery, orderItems);
		
		Delivery delivery2 = new Delivery();
		
		// when
		service.updateDelivery(savedOrder.getId(), delivery2);
		
		// then
		assertEquals(service.findOne(savedOrder.getId()).getDelivery(), delivery2);
		
	}
	
	@Test
	public void shouldCancelOrder() {
		
		// given
		Member member = new Member("철수");
		Delivery delivery = new Delivery();
		Item item = new Item("상품1");
		OrderItem orderItem = new OrderItem(item);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem);
		Order savedOrder = service.createOrder(member, delivery, orderItems);
		
		// when
		service.cancelOrder(savedOrder.getId());
		
		// then
		assertEquals(service.findOne(savedOrder.getId()).getStatus(), OrderStatus.CANCEL);
		
	}
	
	@Test
	public void shouldGetTotalPrice() {
		
		// given
		Member member = new Member("철수");
		Delivery delivery = new Delivery();
		Item item = new Item("상품1");
		OrderItem orderItem = new OrderItem(item);
		orderItem.setOrderPrice(2000);
		Item item2 = new Item("상품2");
		OrderItem orderItem2 = new OrderItem(item2);
		orderItem2.setOrderPrice(5000);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem);
		orderItems.add(orderItem2);
		Order savedOrder = service.createOrder(member, delivery, orderItems);
		
		// when
		int total = service.getTotalPrice(savedOrder.getId());
		
		// then
		assertEquals(total, 7000);
		
	}


}
