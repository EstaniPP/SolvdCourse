package com.solvd.deliveryCenter.models;

public class CustomerPhoneNumber {
	private Long id;
	private String phoneNumber;
	private Long customerId;
	
	public CustomerPhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getPhones() {
		return phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
}
