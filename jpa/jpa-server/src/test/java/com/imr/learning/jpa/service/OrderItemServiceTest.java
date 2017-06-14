package com.imr.learning.jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Order;
import com.imr.learning.jpa.domain.OrderItem;
import com.imr.learning.jpa.domain.OrderStatus;
import com.imr.learning.jpa.domain.item.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderItemServiceTest {

	@Autowired
	OrderItemService service;
	
	@Test
	public void shouldCreateOrderItem() throws NotEnoughStockException {

		// given
		Order order = new Order();
		Item item = new Item();
		item.setStockQuantity(30);
		item.setPrice(200);
		int count = 3;

		// when
		OrderItem savedOrderItem = service.createOrderItem(order, item, count);
		int result = item.getStockQuantity();
		int savedOrderPrice = savedOrderItem.getOrderPrice();

		// then
		assertNotNull(savedOrderItem.getId());
		assertEquals(result, 27);
		assertEquals(savedOrderPrice, 600);
	}
	
	@Test
	public void shouldCancelOrderItem() throws NotEnoughStockException {
		Order order = new Order();
		Item item = new Item();
		item.setStockQuantity(30);
		item.setPrice(200);
		int count = 3;
		OrderItem savedOrderItem = service.createOrderItem(order, item, count);
		List<OrderItem> savedOrderItems = new ArrayList<>();
		savedOrderItems.add(savedOrderItem);
		
		//when
		service.cancelOrderItem(savedOrderItems);
		int result = item.getStockQuantity();
		
		//then
		assertEquals(result, 30);
		assertEquals(order.getStatus(), OrderStatus.CANCEL);
		
	}


}
