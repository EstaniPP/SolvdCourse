package com.solvd.deliveryCenter.models;

public class EmployeeHour {
	private Long id;
	private Long employeeId;
	private java.sql.Time hour;
	private String day;
	
	public EmployeeHour() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHour(java.sql.Time hour) {
		this.hour = hour;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public Long getId() {
		return id;
	}
	
	public java.sql.Time getHour() {
		return hour;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	
	public String getDay() {
		return day;
	}
}
