package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.BusinessHour;

public interface IBusinessHourDAO extends IEntityDAO<BusinessHour>{

	ArrayList<BusinessHour> getHoursByShopId(Long id);
}
