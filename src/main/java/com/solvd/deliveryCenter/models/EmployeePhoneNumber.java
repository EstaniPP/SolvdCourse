package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employeePhoneNumber")

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
	
    @XmlElement
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
    @XmlAttribute
	public Long getId() {
		return id;
	}
	
    @XmlElement
	public Long getEmployeeId() {
		return employeeId;
	}
}
