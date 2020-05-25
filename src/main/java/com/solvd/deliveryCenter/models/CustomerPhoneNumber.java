package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "customerPhoneNumber")

public class CustomerPhoneNumber {
	private Long id;
	private String phoneNumber;
	private Long customerId;
	
	public CustomerPhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
    @XmlElement
	public String getPhones() {
		return phoneNumber;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public Long getCustomerId() {
		return customerId;
	}
}
