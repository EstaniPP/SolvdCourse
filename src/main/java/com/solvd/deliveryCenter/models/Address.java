package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")

public class Address {

	private Long id;
	private Long customerId;
	private String direction;
	private String city;
	private String estate;
	private String postalCode;
	private Customer customer;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getPostalCode() {
		return postalCode;
	}
	
	@XmlElement
	public String getEstate() {
		return estate;
	}
	
	@XmlElement
	public Long getCustomerId() {
		return customerId;
	}
	
	@XmlElement
	public String getCity() {
		return city;
	}
	
	@XmlElement
	public String getDirection() {
		return direction;
	}
	
	@XmlElement
	public Customer getCustomer() {
		return customer;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEstate(String estate) {
		this.estate = estate;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setDirection(String address) {
		this.direction = address;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
