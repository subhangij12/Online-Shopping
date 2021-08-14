package com.example.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the ORDER_TABLE database table.
 * 
 */
@Entity
@Table(name="ORDER_TABLE")

public class OrderTable implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="O_ID")
	private int oId;

	//bi-directional many-to-one association to OrderDetailTable
	@OneToMany(mappedBy="orderTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderDetailTable> orderDetailTables;

	//bi-directional many-to-one association to PaymentTable
	@ManyToOne
	@JoinColumn(name="PAY_ID")
	private PaymentTable paymentTable;

	//bi-directional many-to-one association to UserTable
	@ManyToOne
	@JoinColumn(name="U_ID")
	private UserTable userTable;

	public OrderTable() {
	}

	public int getOId() {
		return this.oId;
	}

	public void setOId(int oId) {
		this.oId = oId;
	}

	public List<OrderDetailTable> getOrderDetailTables() {
		return this.orderDetailTables;
	}

	public void setOrderDetailTables(List<OrderDetailTable> orderDetailTables) {
		this.orderDetailTables = orderDetailTables;
	}

	public OrderDetailTable addOrderDetailTable(OrderDetailTable orderDetailTable) {
		getOrderDetailTables().add(orderDetailTable);
		orderDetailTable.setOrderTable(this);

		return orderDetailTable;
	}

	public OrderDetailTable removeOrderDetailTable(OrderDetailTable orderDetailTable) {
		getOrderDetailTables().remove(orderDetailTable);
		orderDetailTable.setOrderTable(null);

		return orderDetailTable;
	}

	public PaymentTable getPaymentTable() {
		return this.paymentTable;
	}

	public void setPaymentTable(PaymentTable paymentTable) {
		this.paymentTable = paymentTable;
	}

	public UserTable getUserTable() {
		return this.userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

}