package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class Order {
	private Long id;
	private Long vehicleId;
	private Long addressId;
	private Long employeeId;
	private Integer price;
	private java.sql.Date date;
	private ArrayList<ProductInOrder> products;
	private Complain complain;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public void setProducts(ArrayList<ProductInOrder> products) {
		this.products = products;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public Long getVehicleId() {
		return vehicleId;
	}
	
	public ArrayList<ProductInOrder> getProducts() {
		return products;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	
	public java.sql.Date getDate() {
		return date;
	}
	
	public Long getAddressId() {
		return addressId;
	}	
	
	public Complain getComplain() {
		return complain;
	}
	
	public void setComplain(Complain complain) {
		this.complain = complain;
	}
}
