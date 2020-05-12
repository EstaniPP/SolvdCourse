package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private java.sql.Date birthDate;
	private ArrayList<EmployeePhoneNumber> phones;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPhones(ArrayList<EmployeePhoneNumber> phones) {
		this.phones = phones;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public ArrayList<EmployeePhoneNumber> getPhones() {
		return phones;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public java.sql.Date getBirthDate() {
		return birthDate;
	}
}