package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "administrativeEmployee")

public class AdministrativeEmployee extends Employee{
	private Long employeeId;
	private Double salary;
	private ArrayList<EmployeeHour> schedule;
	
	public AdministrativeEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSchedule(ArrayList<EmployeeHour> schedule) {
		this.schedule = schedule;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
    @XmlElementWrapper
    @XmlElement
	public ArrayList<EmployeeHour> getSchedule() {
		return schedule;
	}
	
    @XmlElement
	public Double getSalary() {
		return salary;
	}
	
	public void setEmployeeId(Long employee_id) {
		this.employeeId = employee_id;
	}
	
	@XmlAttribute
	public Long getEmployeeId() {
		return employeeId;
	}
}

