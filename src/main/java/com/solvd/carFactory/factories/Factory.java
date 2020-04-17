package com.solvd.carFactory.factories;

import java.util.ArrayList;

import com.solvd.carFactory.factoryPersonal.EjecutiveEmployee;
import com.solvd.carFactory.factoryPersonal.Employee;
import com.solvd.carFactory.factoryProducts.Order;
import com.solvd.carFactory.factoryProducts.Product;

public abstract class Factory {
	
	private String name;
	private EjecutiveEmployee ceo;
	private Integer stock;
	private String phone;
	protected ArrayList<Department> departments;
	protected ArrayList<Product> products;
	
	public Factory(String name,EjecutiveEmployee ceo,String phone) {
		this.name = name;
		this.ceo= ceo;
		this.stock = 0;
		this.phone= phone;
		this.departments = new ArrayList<Department>();
		this.products = new ArrayList<Product>();
		
	}
	
	public Factory() {
		this.name = "";
		this.ceo = null;
		this.stock = 0;
		this.phone= null ;
		this.departments = new ArrayList<Department>();
		this.products = new ArrayList<Product>();
		
	}
	
	public ArrayList<Department> getDepartments() {
		return departments;
	}
	
	public Employee getCeo() {
		return ceo;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void addDepartments(Department department) {
		this.departments.add(department);
	}
	
	public void setDirector(EjecutiveEmployee ceo) {
		this.ceo = ceo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//director salary plus departements salaries
	public double calculateSalaries() {
		Double salaries = ceo.getSalary();
		for(Department d : departments) {
			salaries += d.calculateSalaries();
		}
		return salaries;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public abstract void addProduct(Product product) throws Exception;
	
	//returns true if factory can produce the order and add production to stock, false in case it can't
	public abstract void produce(Order o) throws Exception;
	
	public Integer getEmployeesQuantity() {
		Integer departmentQty = 0;
		for(Department d :departments) {
			departmentQty += d.getEmployeesQuantity();
		}
		return (ceo.getStatus().isStillInFactory() ? 1 : 0) + departmentQty;
	}
	
}
