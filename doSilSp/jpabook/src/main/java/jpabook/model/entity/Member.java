package jpabook.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {

	@Id
	@GeneratedValue
	private Long memberId;
	private String name;
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String name) {
		super();
		this.name = name;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
