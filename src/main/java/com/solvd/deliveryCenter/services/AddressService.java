package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IAddressDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.ICustomerDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IOrderDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.Order;

public class AddressService {

	private IAddressDAO addressDAO;
	private IOrderDAO orderDAO;
	private ICustomerDAO customerDAO;
	
	public AddressService() {
		addressDAO = SQLSession.getInstance().openSession(true).getMapper(IAddressDAO.class);
		orderDAO = SQLSession.getInstance().openSession(true).getMapper(IOrderDAO.class);
		customerDAO = SQLSession.getInstance().openSession(true).getMapper(ICustomerDAO.class);
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
