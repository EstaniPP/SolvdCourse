package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.deliveryCenter.jaxb.adapters.DateAdapter;

@XmlRootElement(name = "employee")

public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private Long departmentId;
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
	
	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}
	
    @XmlElementWrapper
    @XmlElement
	public ArrayList<EmployeePhoneNumber> getPhones() {
		return phones;
	}
	
    @XmlElement
	public String getLastName() {
		return lastName;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
    @XmlElement
	public String getFirstName() {
		return firstName;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement
	public java.sql.Date getBirthDate() {
		return birthDate;
	}
	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
    @XmlElement
	public Long getDepartmentId() {
		return departmentId;
	}
}
