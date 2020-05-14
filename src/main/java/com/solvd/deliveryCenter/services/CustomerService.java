package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.AddressDAO;
import com.solvd.deliveryCenter.DAO.CustomerDAO;
import com.solvd.deliveryCenter.DAO.CustomerPhoneNumberDAO;
import com.solvd.deliveryCenter.models.Customer;

public class CustomerService {
	
		private CustomerDAO customerDAO;
		private AddressDAO customerAddresses;
		private CustomerPhoneNumberDAO customerPhones;
		
		public CustomerService() {
			customerDAO = new CustomerDAO();
			customerAddresses = new AddressDAO();
			customerPhones = new CustomerPhoneNumberDAO();
		}
		
		public ArrayList<Customer> getCustomers() {
			ArrayList<Customer> customers = customerDAO.getAllEntities();
			customers.stream().forEach(c -> c.setPhones(customerPhones.getPhonesByCustomerID(c.getId())));
			customers.stream().forEach(c -> c.setAddresses(customerAddresses.getAddressesByCustomerID(c.getId())));
			return customers;
		}
		
		public Customer getCostumer(Long id) {
			Customer c = customerDAO.getEntityByID(id);
			c.setPhones(customerPhones.getPhonesByCustomerID(c.getId()));
			c.setAddresses(customerAddresses.getAddressesByCustomerID(c.getId()));
			return c;
		}
		
		public void deleteCustomerByID(Long id) {
			customerDAO.deleteEntityByID(id);
		}
		
		public void updateCosumer(Customer c) {
			customerDAO.updateEntity(c);
		}
}
