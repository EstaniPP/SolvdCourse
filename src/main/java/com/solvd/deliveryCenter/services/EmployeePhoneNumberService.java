package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.EmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.models.EmployeePhoneNumber;

public class EmployeePhoneNumberService {

	private IEmployeePhoneNumberDAO employeePhoneNumberDAO;
	
	public EmployeePhoneNumberService() {
		employeePhoneNumberDAO = new EmployeePhoneNumberDAO();
	}
	
	public ArrayList<EmployeePhoneNumber> getAllEmployeePhoneNumbers(){
		return employeePhoneNumberDAO.getAllEntities();
	}
	
	public ArrayList<EmployeePhoneNumber> getEmployeePhoneNumberByEmployeeID(Long id) {
		return employeePhoneNumberDAO.getPhoneNumbersByEmployeeId(id);
	}
	
	public void updateEmployeePhoneNumber(EmployeePhoneNumber epn) {
		employeePhoneNumberDAO.updateEntity(epn);
	}
	
	public void deleteEmployeePhoneNumber(Long id) {
		employeePhoneNumberDAO.deleteEntityByID(id);
	}
	
	public void saveEntity(EmployeePhoneNumber epn) {
		employeePhoneNumberDAO.saveEntity(epn);
	}
}
