package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.EmployeeHourDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeeHourDAO;
import com.solvd.deliveryCenter.models.EmployeeHour;

public class EmployeeHourService {

	private IEmployeeHourDAO employeeHourDAO;
	
	public EmployeeHourService() {
		employeeHourDAO = new EmployeeHourDAO();
	}
	
	public ArrayList<EmployeeHour> getAllEmployeeHours(){
		return employeeHourDAO.getAllEntities();
	}
	
	public ArrayList<EmployeeHour> getEmployeeHourByEmployeeID(Long id) {
		return employeeHourDAO.getHoursByEmployeeId(id);
	}
	
	public void updateEmployeeHour(EmployeeHour eh) {
		employeeHourDAO.updateEntity(eh);
	}
	
	public void deleteEmployeeHour(Long id) {
		employeeHourDAO.deleteEntityByID(id);
	}
	
	public void saveEntity(EmployeeHour eh) {
		employeeHourDAO.saveEntity(eh);
	}
}
