package com.solvd.carFactory.factoryPersonal;

import java.util.ArrayList;
import java.util.Date;

import com.solvd.carFactory.enums.EmployeePosition;

public class EjecutiveEmployee extends FullTimeEmployee{

	private ArrayList<Employee> subordinates;
	private String sectionInCharge;
	
	public EjecutiveEmployee(String name, String lastname, Integer id, Date dateOfBirth, EmployeePosition position, Double salary, String workShift, String sectionInCharge) {
		super(name,lastname,id,dateOfBirth,position,salary,workShift);
		subordinates = new ArrayList<Employee>();
		this.sectionInCharge = sectionInCharge;
	}
	
	public EjecutiveEmployee() {
	}
	
	public ArrayList<Employee> getSubordinates() {
		return subordinates;
	}
	
	public void addSubordinates(Employee e) {
		subordinates.add(e);
	}
	
	public void setSectionInCharge(String sectionInCharge) {
		this.sectionInCharge = sectionInCharge;
	}
	
	public String getSectionInCharge() {
		return sectionInCharge;
	}
}
