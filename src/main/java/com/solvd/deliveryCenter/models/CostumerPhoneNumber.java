package com.solvd.deliveryCenter.models;

public class CostumerPhoneNumber {
	private Long id;
	private String phoneNumber;
	private Integer costumerId;
	
	public CostumerPhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhones(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCostumerId(Integer costumerId) {
		this.costumerId = costumerId;
	}
	
	public String getPhones() {
		return phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getCostumerId() {
		return costumerId;
	}
}
