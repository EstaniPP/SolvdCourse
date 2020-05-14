package com.solvd.deliveryCenter.models;

public class Vehicle {
	private Long id;
	private Long departmentId;
	private String plate;
	private String model;
	private Integer year;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public String getModel() {
		return model;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}
}
