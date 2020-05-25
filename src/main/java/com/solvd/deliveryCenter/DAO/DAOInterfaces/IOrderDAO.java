package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.Order;

public interface IOrderDAO extends IEntityDAO<Order>{

	ArrayList<Order> getAllOrdersByAddressID(Long id);
	
	ArrayList<Order> getAllOrdersByVehicleID(Long id);
	
	ArrayList<Order> getAllOrdersByEmployeeID(Long id);
	
}
