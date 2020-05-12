package com.solvd.deliveryCenter.models;

public class Vehicle {
	private Long id;
	private Long departmentId;
	private String plate;
	private String type;
	private Integer secureCost;
	private Integer plateCost;
	private String model;
	private Integer year;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setSecureCost(Integer secureCost) {
		this.secureCost = secureCost;
	}
	
	public void setPlateCost(Integer plateCost) {
		this.plateCost = plateCost;
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
	
	public String getType() {
		return type;
	}
	
	public Integer getSecureCost() {
		return secureCost;
	}
	
	public Integer getPlateCost() {
		return plateCost;
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
