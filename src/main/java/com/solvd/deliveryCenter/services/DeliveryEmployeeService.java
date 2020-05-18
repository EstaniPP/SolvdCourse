package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DeliveryEmployeeDAO;
import com.solvd.deliveryCenter.DAO.EmployeeDAO;
import com.solvd.deliveryCenter.DAO.EmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.models.DeliveryEmployee;
import com.solvd.deliveryCenter.models.Employee;

public class DeliveryEmployeeService {
		private EmployeeDAO employeeDAO;
		private DeliveryEmployeeDAO deliveryEmployeeDAO;
		private EmployeePhoneNumberDAO employeePhonesDAO;
		
		public DeliveryEmployeeService() {
			deliveryEmployeeDAO = new DeliveryEmployeeDAO();
			employeeDAO = new EmployeeDAO();
			employeePhonesDAO = new EmployeePhoneNumberDAO();
		}
		
		public ArrayList<DeliveryEmployee> getAllDeliveryEmployee() {
			ArrayList<DeliveryEmployee> list = deliveryEmployeeDAO.getAllEntities();
			list.stream().forEach(obj -> obj.setPhones(employeePhonesDAO.getPhoneNumbersByEmployeeId(obj.getEmployeeId())));
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
			DeliveryEmployee emp = deliveryEmployeeDAO.getEntityByID(id);
			emp.setPhones(employeePhonesDAO.getPhoneNumbersByEmployeeId(emp.getEmployeeId()));
			Employee employee = employeeDAO.getEntityByID(emp.getEmployeeId());
			emp.setBirthDate(employee.getBirthDate());
			emp.setDepartmentId(employee.getDepartmentId());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setId(employee.getId());
			return emp;
		}
		
		public void saveDeliveryEmployee(DeliveryEmployee e) {
			deliveryEmployeeDAO.saveEntity(e);
			employeeDAO.saveEntity(e);
		}
		
		public void deleteDeliveryEmployee(DeliveryEmployee e) {
			employeeDAO.deleteEntityByID(e.getEmployeeId());
		}
		
		public void updateDeliveryEmployee(DeliveryEmployee e) {
			employeeDAO.updateEntity(e);
			deliveryEmployeeDAO.updateEntity(e);
		}
		
}