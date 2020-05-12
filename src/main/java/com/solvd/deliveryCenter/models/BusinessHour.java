package com.solvd.deliveryCenter.models;

public class BusinessHour {
	private Long id;
	private Long shopId;
	private String day;
	private java.sql.Time hour;
	
	public BusinessHour() {
		// TODO Auto-generated constructor stub
	}
	
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHour(java.sql.Time hour) {
		this.hour = hour;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public Long getShopId() {
		return shopId;
	}
	
	public Long getId() {
		return id;
	}
	
	public java.sql.Time getHour() {
		return hour;
	}
	
	public String getDay() {
		return day;
	}	
}
