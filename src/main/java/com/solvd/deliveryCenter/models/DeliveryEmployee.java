package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class DeliveryEmployee extends Employee{
	private Long deliveryFee;
	private String License;
	private ArrayList<Order> orders;
	
	public DeliveryEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public void setLicense(String license) {
		License = license;
	}
	
	public void setDeliveryFee(Long deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	public String getLicense() {
		return License;
	}
	
	public Long getDeliveryFee() {
		return deliveryFee;
	}
	
	public void setOrder(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public ArrayList<Order> getOrder() {
		return orders;
	}
}
