package com.solvd.carFactory.factories;

import java.util.ArrayList;

import com.solvd.carFactory.factoryPersonal.Employee;

public class Department {

	private String name;
	private String specialization;
	private ArrayList<Employee> employees;
	private Employee departmentDirector;
	
	public Department(String specialization,Employee departmentDirector) {
		this.specialization = specialization;
		this.departmentDirector = departmentDirector;
		employees = new ArrayList<Employee>();
	}
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee getDepartmentDirector() {
		return departmentDirector;
	}
	
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> a = ((ArrayList<Employee>) employees.clone());
		a.add(getDepartmentDirector());
		return a;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public void setDepartmentDirector(Employee departmentDirector) {
		this.departmentDirector = departmentDirector;
	}
	
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public double calculateSalaries() {
		Double salaries = departmentDirector.getSalary();
		for(Employee e : employees) {
			salaries += e.getSalary();
		}
		return salaries;
	}

	public Integer getEmployeesQuantity() {
		Integer quantity = departmentDirector.getStatus().isStillInFactory() ? 1 : 0;
		for(Employee e : employees) {
			quantity += e.getStatus().isStillInFactory() ? 1 : 0;
		}
		return quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
