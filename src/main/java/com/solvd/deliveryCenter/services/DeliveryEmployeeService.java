package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DeliveryEmployeeDAO;
import com.solvd.deliveryCenter.DAO.EmployeeDAO;
import com.solvd.deliveryCenter.DAO.EmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.models.DeliveryEmployee;
import com.solvd.deliveryCenter.models.Employee;

public class DeliveryEmployeeService {
		private EmployeeDAO employeeDAO;
		private DeliveryEmployeeDAO aEmployeeDAO;
		private EmployeePhoneNumberDAO employeePhones;
		
		public DeliveryEmployeeService() {
			aEmployeeDAO = new DeliveryEmployeeDAO();
			employeeDAO = new EmployeeDAO();
			employeePhones = new EmployeePhoneNumberDAO();
		}
		
		public ArrayList<DeliveryEmployee> getAllDeliveryEmployee() {
			ArrayList<DeliveryEmployee> list = aEmployeeDAO.getAllEntities();
			list.stream().forEach(obj -> obj.setPhones(employeePhones.getHoursByEmployeeId(obj.getEmployeeId())));
			for(DeliveryEmployee emp : list) {
				Employee employee = employeeDAO.getEntityByID(emp.getEmployeeId());
				emp.setBirthDate(employee.getBirthDate());
				emp.setDepartmentId(employee.getDepartmentId());
				emp.setFirstName(employee.getFirstName());
				emp.setLastName(employee.getLastName());
				emp.setId(employee.getId());
			}
			return list;
		}
		
		public DeliveryEmployee getDeliveryEmployeeById(Long id) {
			DeliveryEmployee emp = aEmployeeDAO.getEntityByID(id);
			emp.setPhones(employeePhones.getHoursByEmployeeId(emp.getEmployeeId()));
			Employee employee = employeeDAO.getEntityByID(emp.getEmployeeId());
			emp.setBirthDate(employee.getBirthDate());
			emp.setDepartmentId(employee.getDepartmentId());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setId(employee.getId());
			return emp;
		}
		
		
}