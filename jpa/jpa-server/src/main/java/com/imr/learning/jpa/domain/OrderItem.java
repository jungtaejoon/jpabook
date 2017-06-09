package com.imr.learning.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.imr.learning.jpa.domain.item.Item;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERS_ID")
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	private Integer orderPrice;
	private Integer count;

	public OrderItem() {
		super();
	}

	public OrderItem(Item item) {
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if(this.order != null) {
			this.order.getOrderItems().remove(this);
		}
		this.order = order;
		order.getOrderItems().add(this);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", item=" + item + ", orderPrice=" + orderPrice + ", count="
				+ count + "]";
	}

}
