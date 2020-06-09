package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DBInfoDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IAdministrativeEmployeeDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IDBInfoDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeeDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeeHourDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEmployeePhoneNumberDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.models.AdministrativeEmployee;
import com.solvd.deliveryCenter.models.Employee;

public class AdministrativeEmployeeService {
	
		private IEmployeeHourDAO employeeHours;
		private IEmployeeDAO employeeDAO;
		private IAdministrativeEmployeeDAO administrativeEmployeeDAO;
		private IEmployeePhoneNumberDAO employeePhones;
		private IDBInfoDAO dbinfo;
		
		public AdministrativeEmployeeService() {
			administrativeEmployeeDAO = SQLSession.getInstance().openSession(true).getMapper(IAdministrativeEmployeeDAO.class);
			employeeHours = SQLSession.getInstance().openSession(true).getMapper(IEmployeeHourDAO.class);
			employeeDAO = SQLSession.getInstance().openSession(true).getMapper(IEmployeeDAO.class);
			employeePhones = SQLSession.getInstance().openSession(true).getMapper(IEmployeePhoneNumberDAO.class);
			dbinfo = new DBInfoDAO();
		}
		
		public ArrayList<AdministrativeEmployee> getAllAdministrativeEmployees() {
			ArrayList<AdministrativeEmployee> list = administrativeEmployeeDAO.getAllEntities();
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
			AdministrativeEmployee emp = administrativeEmployeeDAO.getEntityByID(id);
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
			employeeDAO.saveEntity(e);
			e.setEmployeeId(dbinfo.getLastID());
			administrativeEmployeeDAO.saveEntity(e);
		}
		
		public void deleteAdministrativeEmployee(Long id) {
			employeeDAO.deleteEntityByID(id);
		}
		
		public void updateAdministrativeEmployee(AdministrativeEmployee e) {
			employeeDAO.updateEntity(e);
			administrativeEmployeeDAO.updateEntity(e);
		}
}
