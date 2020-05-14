package com.solvd.deliveryCenter.models;

public class CostumerPhoneNumber {
	private Long id;
	private String phoneNumber;
	private Long costumerId;
	
	public CostumerPhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhones(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCostumerId(Long costumerId) {
		this.costumerId = costumerId;
	}
	
	public String getPhones() {
		return phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getCostumerId() {
		return costumerId;
	}
}
