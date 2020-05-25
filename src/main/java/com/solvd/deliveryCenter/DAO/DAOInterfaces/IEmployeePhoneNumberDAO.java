package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.EmployeePhoneNumber;

public interface IEmployeePhoneNumberDAO extends IEntityDAO<EmployeePhoneNumber>{

	ArrayList<EmployeePhoneNumber> getPhoneNumbersByEmployeeId (Long id);
	
}