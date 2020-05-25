package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.EmployeeHour;

public interface IEmployeeHourDAO extends IEntityDAO<EmployeeHour>{

	ArrayList<EmployeeHour> getHoursByEmployeeId (Long id);
	
}