package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.AdministrativeEmployeeDAO;
import com.solvd.deliveryCenter.DAO.EmployeeDAO;
import com.solvd.deliveryCenter.DAO.EmployeeHourDAO;
import com.solvd.deliveryCenter.DAO.EmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.models.AdministrativeEmployee;
import com.solvd.deliveryCenter.models.Employee;

public class AdministrativeEmployeeService {
	
		private EmployeeHourDAO employeeHours;
		private EmployeeDAO employeeDAO;
		private AdministrativeEmployeeDAO aEmployeeDAO;
		private EmployeePhoneNumberDAO employeePhones;
		
		public AdministrativeEmployeeService() {
			aEmployeeDAO = new AdministrativeEmployeeDAO();
			employeeHours = new EmployeeHourDAO();
			employeeDAO = new EmployeeDAO();
			employeePhones = new EmployeePhoneNumberDAO();
		}
		
		public ArrayList<AdministrativeEmployee> getAllAdministrativeEmployees() {
			ArrayList<AdministrativeEmployee> list = aEmployeeDAO.getAllEntities();
			list.stream().forEach(obj -> obj.setSchedule(employeeHours.getHoursByEmployeeId(obj.getEmployeeId())));
			list.stream().forEach(obj -> obj.setPhones(employeePhones.getPhoneNumbersByEmployeeId(obj.getEmployeeId())));
			for(AdministrativeEmployee emp : list) {
				Employee employee = employeeDAO.getEntityByID(emp.getEmployeeId());
				emp.setBirthDate(employee.getBirthDate());
				emp.setDepartmentId(employee.getDepartmentId());
				emp.setFirstName(employee.getFirstName());
				emp.setLastName(employee.getLastName());
				emp.setId(employee.getId());
			}
			return list;
		}
		
		public AdministrativeEmployee getAdministrativeEmployeeById(Long id) {
			AdministrativeEmployee emp = aEmployeeDAO.getEntityByID(id);
			emp.setSchedule(employeeHours.getHoursByEmployeeId(emp.getEmployeeId()));
			emp.setPhones(employeePhones.getPhoneNumbersByEmployeeId(emp.getEmployeeId()));
			Employee employee = employeeDAO.getEntityByID(emp.getEmployeeId());
			emp.setBirthDate(employee.getBirthDate());
			emp.setDepartmentId(employee.getDepartmentId());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setId(employee.getId());
			return emp;
		}
		
		public void saveAdministrativeEmployee(AdministrativeEmployee e) {
			aEmployeeDAO.saveEntity(e);
			employeeDAO.saveEntity(e);
		}
		
		public void deleteAdministrativeEmployee(AdministrativeEmployee e) {
			employeeDAO.deleteEntityByID(e.getEmployeeId());
		}
		
		public void updateAdministrativeEmployee(AdministrativeEmployee e) {
			employeeDAO.updateEntity(e);
			aEmployeeDAO.updateEntity(e);
		}
}
