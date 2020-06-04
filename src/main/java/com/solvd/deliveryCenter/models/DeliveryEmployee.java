package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deliveryEmployee")

public class DeliveryEmployee extends Employee{
	private Long employeeId;
	private Long deliveryFee;
	private String license;
	
	public DeliveryEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
	
	public void setDeliveryFee(Long deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	
    @XmlElement
	public String getLicense() {
		return license;
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
