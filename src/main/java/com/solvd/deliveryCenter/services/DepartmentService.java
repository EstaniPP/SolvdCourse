package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IDepartmentDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.models.Department;

public class DepartmentService {
	
	private IDepartmentDAO dDAO;
	
	public DepartmentService() {
		dDAO = SQLSession.getInstance().openSession(true).getMapper(IDepartmentDAO.class);
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
