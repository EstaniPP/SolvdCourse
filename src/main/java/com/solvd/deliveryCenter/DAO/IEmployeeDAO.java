package com.solvd.deliveryCenter.DAO;

import com.solvd.deliveryCenter.models.AdministrativeEmployee;
import com.solvd.deliveryCenter.models.DeliveryEmployee;
import com.solvd.deliveryCenter.models.Employee;

public interface IEmployeeDAO extends IEnitityDAO<Employee>{
	void setDeliveryEmployeeValues(DeliveryEmployee de);
	
	void setAdministrativeEmployeeValues(AdministrativeEmployee ae);
}
