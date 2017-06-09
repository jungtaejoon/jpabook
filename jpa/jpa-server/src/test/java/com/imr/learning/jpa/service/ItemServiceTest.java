package com.imr.learning.jpa.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.item.Item;
import com.imr.learning.jpa.repository.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

	@Autowired
	ItemService service;
	
	@Autowired
	ItemRepository repository;

	@Test
	public void shouldSave() {

		// given
		Item item = new Item();
		item.setName("상품1");

		// when
		service.saveItem(item);

		// then
		assertEquals(repository.findOne(item.getId()).getName(), "상품1");
	}

	@Test
	public void shouldFindByName() {

		// given
		Item item = new Item();
		item.setName("상품1");
		service.saveItem(item);

		// when
		List<Item> foundItem = service.findByName("상품1");

		// then
		assertEquals(foundItem.get(0), item);

	}

	@Test
	public void shouldFindAll() {

		// given
		Item item1 = new Item();
		Item item2 = new Item();
		item1.setName("상품1");
		item2.setName("상품2");
		service.saveItem(item1);
		service.saveItem(item2);
		List<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);

		// when
		List<Item> foundItems = service.findAllItem();

		// then
		assertEquals(foundItems, items);
	}

	@Test
	public void shouldInc() {

		// given
		Item item = new Item();
		item.setStockQuantity(1);
		service.saveItem(item);
		Long savedId = item.getId();

		// when
		service.incStock(item);

		// then
		int foundStockQuantity = service.findItem(savedId).getStockQuantity();
		assertEquals(foundStockQuantity, 2);
	}
	
	@Test
	public void shouldDec() throws NotEnoughStockException {
		
		// given
		Item item = new Item();
		item.setStockQuantity(2);
		service.saveItem(item);
		Long savedId = item.getId();
		
		// when
		service.decStock(item);
		
		// then
		int foundStockQuantity = service.findItem(savedId).getStockQuantity();
		assertEquals(foundStockQuantity, 1);
	}

	@Test
	public void shouldUpdateStock() throws NotEnoughStockException {

		// given
		Item item = new Item();
		item.setStockQuantity(1);
		service.saveItem(item);
		Long savedId = item.getId();

		// when
		service.updateStock(item, 4);

		// then
		int foundStockQuantity = service.findItem(savedId).getStockQuantity();
		assertEquals(foundStockQuantity, 4);
	}

	@Test
	public void shouldCalculateStock() throws NotEnoughStockException {

		// given
		Item item = new Item();
		item.setStockQuantity(1);
		service.saveItem(item);
		Long savedId = item.getId();

		// when
		service.calStock(4, item);

		// then
		int foundStockQuantity = service.findItem(savedId).getStockQuantity();
		assertEquals(foundStockQuantity, 5);
	}

}
