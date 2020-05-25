package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.AddressDAO;
import com.solvd.deliveryCenter.DAO.CustomerDAO;
import com.solvd.deliveryCenter.DAO.OrderDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEntityDAO;
import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.Customer;
import com.solvd.deliveryCenter.models.Order;

public class AddressService {

	private AddressDAO addressDAO;
	private OrderDAO orderDAO;
	private IEntityDAO<Customer> customerDAO;
	
	public AddressService() {
		addressDAO = new AddressDAO();
		orderDAO = new OrderDAO();
		customerDAO = new CustomerDAO();
	}
	
	public ArrayList<Address> getAllAdresses(){
		ArrayList<Address> list = addressDAO.getAllEntities();
		list.stream().forEach(obj -> obj.setCustomer(customerDAO.getEntityByID(obj.getCustomerId())));
		return list;
	}
	
	public ArrayList<Address> getAllAdressesByCostumerID(Long id){
		return addressDAO.getAddressesByCustomerID(id);
	}
	
	public ArrayList<Order> getAllAddressOrders(Long id){
		return orderDAO.getAllOrdersByAddressID(id);
	}
	
	public void updateAddress(Address a) {
		addressDAO.updateEntity(a);
	}
	
	public void deleteAddress(Long id) {
		addressDAO.deleteEntityByID(id);
	}
	
	public void saveAddress(Address a) {
		addressDAO.saveEntity(a);
	}
}
