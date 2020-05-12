package com.solvd.deliveryCenter.models;

public class Complain {
	private Long id;
	private Long orderId;
	private String description;
	private java.sql.Date date;
	
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
}
