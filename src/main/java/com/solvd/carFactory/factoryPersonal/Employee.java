package com.solvd.carFactory.factoryPersonal;

import java.util.Date;

import com.solvd.carFactory.enums.EmployeePosition;
import com.solvd.carFactory.enums.EmployeeStatus;

public abstract class Employee {

	private String name;
	private String lastname;
	private Integer id;
	private Date dateOfBirth;
	private EmployeePosition position;
	private EmployeeStatus status;
	
	public Employee() {
	}
	
	public Employee(String name, String lastname, Integer id, Date dateOfBirth, EmployeePosition position) {
		this.name = name;
		this.lastname = lastname;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.position = position;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getName() {
		return name;
	}
	
	public EmployeePosition getPosition() {
		return position;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(EmployeePosition position) {
		this.position = position;
	}
	
	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}
	
	public EmployeeStatus getStatus() {
		return status;
	}
	public abstract Double getSalary();
	
	@Override
	public String toString() {
		return "Employee: "+name+" salary "+this.getSalary();
	}
}
