package com.imr.learning.jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Order;
import com.imr.learning.jpa.domain.OrderItem;
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
		int orderPrice = 300;
		int count = 3;

		// when
		OrderItem savedOrderItem = service.createOrderItem(order, item, orderPrice, count);
		int namerge = item.getStockQuantity();

		// then
		assertNotNull(savedOrderItem.getId());
		assertEquals(namerge, 27);
	}


}
