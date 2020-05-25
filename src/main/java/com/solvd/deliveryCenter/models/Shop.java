package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shop")

public class Shop {
	private Long id;
	private Long companyId;
	private String address;
	private String phoneNumber;
	private String email;
	private ArrayList<BusinessHour> openHours;
	private ArrayList<Product> products;
	private Company company;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
	public String getEmail() {
		return email;
	}
	
	@XmlElement
	public Long getCompanyId() {
		return companyId;
	}
	
	@XmlElement
	public String getAddress() {
		return address;
	}
	
	public void setOpenHours(ArrayList<BusinessHour> openHours) {
		this.openHours = openHours;
	}

    @XmlElementWrapper
	@XmlElement
	public ArrayList<BusinessHour> getOpenHours() {
		return openHours;
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
    @XmlElementWrapper
	@XmlElement
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@XmlElement
	public Company getCompany() {
		return company;
	}
}
