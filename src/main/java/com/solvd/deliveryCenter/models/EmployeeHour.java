package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.deliveryCenter.jaxb.adapters.TimeAdapter;

@XmlRootElement(name = "employeeHour")

public class EmployeeHour {
	private Long id;
	private Long employeeId;
	private java.sql.Time hour;
	private String day;
	
	public EmployeeHour() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHour(java.sql.Time hour) {
		this.hour = hour;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlJavaTypeAdapter(TimeAdapter.class)
	@XmlElement
	public java.sql.Time getHour() {
		return hour;
	}
	
	@XmlElement
	public Long getEmployeeId() {
		return employeeId;
	}
	
	@XmlElement
	public String getDay() {
		return day;
	}
}
