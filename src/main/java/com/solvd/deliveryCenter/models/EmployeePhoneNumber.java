package com.solvd.deliveryCenter.models;

public class EmployeePhoneNumber {
	private Long id;
	private String phoneNumber;
	private Long employeeId;
	
	public EmployeePhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
}
