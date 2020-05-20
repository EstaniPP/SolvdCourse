package com.solvd.deliveryCenter.models;

public class Complain {
	private Long id;
	private Long orderId;
	private String description;
	private java.sql.Date date;
	private Order order;
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public java.sql.Date getDate() {
		return date;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
}
