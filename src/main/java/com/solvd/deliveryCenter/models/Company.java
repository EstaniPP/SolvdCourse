package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")


public class Company {
	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private ArrayList<Shop> shops;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	public void setShops(ArrayList<Shop> shops) {
		this.shops = shops;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
    @XmlElementWrapper
	@XmlElement
	public ArrayList<Shop> getShops() {
		return shops;
	}
	
	@XmlElement
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}
}
