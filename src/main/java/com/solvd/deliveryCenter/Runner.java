package com.solvd.deliveryCenter;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.AdministrativeEmployee;
import com.solvd.deliveryCenter.models.Customer;
import com.solvd.deliveryCenter.services.AddressService;
import com.solvd.deliveryCenter.services.AdministrativeEmployeeService;
import com.solvd.deliveryCenter.services.CustomerService;


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
		

		customer = customerService.getCustomers().get(0);
		
		AddressService addressService = new AddressService();
		Address address = new Address();
		address.setAddress("address");
		address.setCity("New York");
		address.setCustomerId(customer.getId());
		address.setEstate("California");
		address.setPostalCode("10000");
		addressService.saveAddress(address);
		
		for(Customer c : customerService.getCustomers()) {
			LOGGER.info("Customer: "+ c.getId());
			for(Address a : addressService.getAllAdressesByCostumerID(c.getId())) {
				LOGGER.info("Customer address: "+ a.getId() +" "+ a.getAddress());
			}
		}
		
		for(Customer c : customerService.getCustomers()) {
			customerService.deleteCustomerByID(c.getId());
		}
		
		AdministrativeEmployee ae = new AdministrativeEmployee();
		AdministrativeEmployeeService aeService = new AdministrativeEmployeeService();

		
		
	}

}
