package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deliveryEmployee")

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
	
	
    @XmlElement
	public String getLicense() {
		return License;
	}
	
    @XmlElement
    public Long getDeliveryFee() {
		return deliveryFee;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	@XmlAttribute
	public Long getEmployeeId() {
		return employeeId;
	}
}
