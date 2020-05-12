package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class Shop {
	private Long id;
	private Long companyId;
	private String address;
	private String phoneNumber;
	private String email;
	private ArrayList<BusinessHour> openHours;
	
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setOpenHours(ArrayList<BusinessHour> openHours) {
		this.openHours = openHours;
	}
	
	public ArrayList<BusinessHour> getOpenHours() {
		return openHours;
	}
}
