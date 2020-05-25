package com.solvd.deliveryCenter.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle")

public class Vehicle {
	private Long id;
	private Long departmentId;
	private String plate;
	private String model;
	private Integer year;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
    @XmlElement
	public Integer getYear() {
		return year;
	}
	
    @XmlElement
	public String getPlate() {
		return plate;
	}
	
    @XmlElement
	public String getModel() {
		return model;
	}
	
    @XmlAttribute
	public Long getId() {
		return id;
	}
	
    @XmlElement
	public Long getDepartmentId() {
		return departmentId;
	}
}
