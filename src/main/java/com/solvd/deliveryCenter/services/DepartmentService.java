package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DepartmentDAO;
import com.solvd.deliveryCenter.models.Department;

public class DepartmentService {
	
	private DepartmentDAO dDAO;
	
	public DepartmentService() {
		dDAO = new DepartmentDAO();
	}

	public ArrayList<Department> getAllDepartments(){
		return dDAO.getAllEntities();
	}
	
	public Department getDepartmentByID(Long id) {
		return dDAO.getEntityByID(id);
	}
	
	public void deleteDepartment(Long id) {
		dDAO.deleteEntityByID(id);
	}
	
	public void saveDepartment(Department d) {
		dDAO.saveEntity(d);
	}
	
	public void updateDepartment(Department d) {
		dDAO.updateEntity(d);
	}
}
