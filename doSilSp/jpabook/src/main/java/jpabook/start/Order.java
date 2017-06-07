package jpabook.start;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "oreders")
public class Order {

	@Id
	@GeneratedValue
	private Long orderId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;

	public Order() {
		super();
	}

	public Order(Date orderdate, OrderStatus status, Member member, List<OrderItem> orderItems) {
		super();
		this.orderdate = orderdate;
		this.status = status;
		this.member = member;
		this.orderItems = orderItems;
	}

	public Order(Date orderdate, OrderStatus status, Member member, List<OrderItem> orderItems, Delivery delivery) {
		super();
		this.orderdate = orderdate;
		this.status = status;
		this.member = member;
		this.orderItems = orderItems;
		this.delivery = delivery;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		if (this.member != null) {
			this.member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		delivery.setOrder(this);
		this.delivery = delivery;
	}
}
