package com.solvd.deliveryCenter.DAO;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.CustomerPhoneNumber;

public interface ICustomerPhoneNumberDAO extends IEntityDAO<CustomerPhoneNumber>{

	ArrayList<CustomerPhoneNumber> getPhonesByCustomerID(Long id);
}
