package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

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
	
	public ArrayList<Shop> getShops() {
		return shops;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
}
