package com.solvd.carFactory.factoryPersonal;

import java.util.Date;

import com.solvd.carFactory.enums.EmployeePosition;

public abstract class FullTimeEmployee extends Employee{
	private Double salary;
	private String workShift;
	
	public FullTimeEmployee(String name, String lastname, Integer id, Date dateOfBirth, EmployeePosition position, Double salary, String workShift) {
		super(name,lastname,id,dateOfBirth,position);
		this.salary = salary;
		this.workShift = workShift; 
	}
	
	public FullTimeEmployee() {
	}
	
	public Double getSalary() {
		if(salary == null) {
			return 0.0d;
		}
		return salary * super.getStatus().getPercentajeAmount();
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String getWorkShift() {
		return workShift;
	}
	
	public void setWorkShift(String workShift) {
		this.workShift = workShift;
	}
}
