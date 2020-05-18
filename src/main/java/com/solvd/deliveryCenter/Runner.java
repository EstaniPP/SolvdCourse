package com.solvd.deliveryCenter;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.AdministrativeEmployee;
import com.solvd.deliveryCenter.models.Customer;
import com.solvd.deliveryCenter.models.Department;
import com.solvd.deliveryCenter.services.AddressService;
import com.solvd.deliveryCenter.services.AdministrativeEmployeeService;
import com.solvd.deliveryCenter.services.CustomerService;
import com.solvd.deliveryCenter.services.DepartmentService;


public class Runner {

	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Customer customer = new Customer();
		customer.setBirthDate(Date.valueOf("1997-04-29"));
		customer.setEmail("email@email.com");
		customer.setFirstName("Mathew");
		customer.setLastName("Fraser");
		customerService.saveCosumer(customer);
		

		customer = customerService.getAllCustomers().get(0);
		
		AddressService addressService = new AddressService();
		Address address = new Address();
		address.setAddress("address");
		address.setCity("New York");
		address.setCustomerId(customer.getId());
		address.setEstate("California");
		address.setPostalCode("10000");
		addressService.saveAddress(address);
		
		for(Customer c : customerService.getAllCustomers()) {
			LOGGER.info("Customer: "+ c.getId());
			for(Address a : addressService.getAllAdressesByCostumerID(c.getId())) {
				LOGGER.info("Customer address: "+ a.getId() +" "+ a.getAddress());
			}
		}
		
		for(Customer c : customerService.getAllCustomers()) {
			customerService.deleteCustomer(c.getId());
		}

		DepartmentService dService = new DepartmentService();
		Department dep = new Department();
		dep.setAddress("address");
		dep.setEmail("department@email.com");
		dep.setEspecialization("delivery");
		dep.setPhoneNumber("+54-2249305924");
		
		dService.saveDepartment(dep);
		
		dep = dService.getAllDepartments().get(0);
		
		AdministrativeEmployee ae = new AdministrativeEmployee();
		AdministrativeEmployeeService aeService = new AdministrativeEmployeeService();
		
		ae.setBirthDate(Date.valueOf("1985-02-02"));
		ae.setDepartmentId(dep.getId());
		ae.setFirstName("Jhon");
		ae.setLastName("Jones");
		ae.setSalary(30000.0);
		
		aeService.saveAdministrativeEmployee(ae);
		
		ae = aeService.getAllAdministrativeEmployees().get(0);
		
		LOGGER.info("Administrative employee: "+ ae.getId() +" " + ae.getEmployeeId() +" "+ ae.getFirstName() +" "+ ae.getLastName() +" "+ ae.getDepartmentId() +" "+ ae.getSalary());
		
		ae.setLastName("New Last Name");
		ae.setSalary(35000.0);
		
		aeService.updateAdministrativeEmployee(ae);
		
		ae = aeService.getAllAdministrativeEmployees().get(0);
		
		LOGGER.info("Administrative employee: "+ ae.getId() +" " + ae.getEmployeeId() +" "+ ae.getFirstName() +" "+ ae.getLastName() +" "+ ae.getDepartmentId() +" "+ ae.getSalary());
		
		aeService.getAllAdministrativeEmployees().forEach(obj -> aeService.deleteAdministrativeEmployee(obj.getId()));
		dService.getAllDepartments().forEach(obj -> dService.deleteDepartment(obj.getId()));
	}

}
