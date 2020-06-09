package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IAddressDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.ICustomerDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.ICustomerPhoneNumberDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IOrderDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.models.Customer;
import com.solvd.deliveryCenter.models.Order;

public class CustomerService {
	
		private ICustomerDAO customerDAO;
		private IAddressDAO customerAddresses;
		private ICustomerPhoneNumberDAO customerPhones;
		private IOrderDAO orderDAO;
		
		public CustomerService() {
			customerDAO = SQLSession.getInstance().openSession(true).getMapper(ICustomerDAO.class);
			customerAddresses = SQLSession.getInstance().openSession(true).getMapper(IAddressDAO.class);
			customerPhones = SQLSession.getInstance().openSession(true).getMapper(ICustomerPhoneNumberDAO.class);
			orderDAO = SQLSession.getInstance().openSession(true).getMapper(IOrderDAO.class);
		}
		
		public ArrayList<Customer> getAllCustomers() {
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
		
		public void deleteCustomer(Long id) {
			customerDAO.deleteEntityByID(id);
		}
		
		public void updateCosumer(Customer c) {
			customerDAO.updateEntity(c);
		}
		
		public void saveCosumer(Customer c) {
			customerDAO.saveEntity(c);
		}
		
		public ArrayList<Order> getAllCustomerOrders(Long id){
			ArrayList<Order> orders = new ArrayList<Order>();
			customerAddresses.getAddressesByCustomerID(id).stream().map(a -> orders.addAll(orderDAO.getAllOrdersByAddressID(a.getId())));
			return orders;
		}
}
