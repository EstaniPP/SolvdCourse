package com.solvd.deliveryCenter.models;

public class Address {

	private Long id;
	private Long customerId;
	private String address;
	private String city;
	private String estate;
	private String postalCode;
	private Customer customer;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEstate(String estate) {
		this.estate = estate;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEstate() {
		return estate;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
