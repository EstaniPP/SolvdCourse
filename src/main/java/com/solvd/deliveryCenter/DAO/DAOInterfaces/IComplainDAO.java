package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import com.solvd.deliveryCenter.models.Complain;

public interface IComplainDAO extends IEntityDAO<Complain>{

	Complain getComplainByOrderID(Long id);
}