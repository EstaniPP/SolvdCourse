package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DBInfoDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IDBInfoDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IDeliveryEmployeeDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeeDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.models.DeliveryEmployee;
import com.solvd.deliveryCenter.models.Employee;

public class DeliveryEmployeeService {
		private IEmployeeDAO employeeDAO;
		private IDeliveryEmployeeDAO deliveryEmployeeDAO;
		private IEmployeePhoneNumberDAO employeePhonesDAO;
		private IDBInfoDAO dbinfo;
		
		public DeliveryEmployeeService() {
			deliveryEmployeeDAO = SQLSession.getInstance().openSession(true).getMapper(IDeliveryEmployeeDAO.class);
			employeeDAO = SQLSession.getInstance().openSession(true).getMapper(IEmployeeDAO.class);
			employeePhonesDAO = SQLSession.getInstance().openSession(true).getMapper(IEmployeePhoneNumberDAO.class);
			dbinfo = new DBInfoDAO();
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
			employeeDAO.saveEntity(e);
			e.setEmployeeId(dbinfo.getLastID());
			deliveryEmployeeDAO.saveEntity(e);
		}
		
		public void deleteDeliveryEmployee(Long id) {
			employeeDAO.deleteEntityByID(id);
		}
		
		public void updateDeliveryEmployee(DeliveryEmployee e) {
			employeeDAO.updateEntity(e);
			deliveryEmployeeDAO.updateEntity(e);
		}
		
}