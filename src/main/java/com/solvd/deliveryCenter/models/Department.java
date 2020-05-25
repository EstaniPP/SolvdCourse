package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")

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
	
	@XmlElement
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getEspecialization() {
		return especialization;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}
	
	@XmlElement
	public Long getCeoId() {
		return ceoId;
	}
	
	@XmlElement
	public String getAddress() {
		return address;
	}
	
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
    @XmlElementWrapper
    @XmlElement
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	@XmlElementWrapper
    @XmlElement
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
}
