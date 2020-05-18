package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.AddressDAO;
import com.solvd.deliveryCenter.DAO.OrderDAO;
import com.solvd.deliveryCenter.models.Address;
import com.solvd.deliveryCenter.models.Order;

public class AddressService {

	private AddressDAO addressDAO;
	private OrderDAO orderDAO;
	
	public AddressService() {
		addressDAO = new AddressDAO();
		orderDAO = new OrderDAO();
	}
	
	public ArrayList<Address> getAllAdresses(){
		return addressDAO.getAllEntities();
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
