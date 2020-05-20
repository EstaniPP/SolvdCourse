package com.solvd.deliveryCenter.models;

public class DeliveryEmployee extends Employee{
	private Long employeeId;
	private Long deliveryFee;
	private String License;
	
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
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
}
