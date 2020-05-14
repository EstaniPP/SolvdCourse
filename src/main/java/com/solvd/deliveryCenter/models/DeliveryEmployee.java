package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class DeliveryEmployee extends Employee{
	private Long employeeId;
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
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
}
