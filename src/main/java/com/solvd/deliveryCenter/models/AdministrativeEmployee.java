package com.solvd.deliveryCenter.models;

import java.util.ArrayList;

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
	
	public ArrayList<EmployeeHour> getSchedule() {
		return schedule;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setEmployeeId(Long employee_id) {
		this.employeeId = employee_id;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
}

