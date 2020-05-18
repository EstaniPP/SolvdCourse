package com.solvd.deliveryCenter.DAO;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.EmployeePhoneNumber;

public interface IEmployeePhoneNumberDAO extends IEntityDAO<EmployeePhoneNumber>{

	ArrayList<EmployeePhoneNumber> getPhoneNumbersByEmployeeId (Long id);
	
}