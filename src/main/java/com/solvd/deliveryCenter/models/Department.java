package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class Department {
	private Long id;
	private String especialization;
	private String address;
	private String phoneNumber;
	private String email;
	private Long ceoId;
	private ArrayList<Employee> employees;
	private ArrayList<Vehicle> vehicles;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEspecialization(String especialization) {
		this.especialization = especialization;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCeoId(Long ceoId) {
		this.ceoId = ceoId;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEspecialization() {
		return especialization;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getCeoId() {
		return ceoId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
}
