package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.Address;

public interface IAddressDAO extends IEntityDAO<Address>{

	ArrayList<Address> getAddressesByCustomerID(Long id);
}
