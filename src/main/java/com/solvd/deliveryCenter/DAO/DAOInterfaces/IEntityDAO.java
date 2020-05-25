package com.solvd.deliveryCenter.DAO.DAOInterfaces;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface IEntityDAO<T> {
		T getEntityByID(Long id);
		
		ArrayList<T> getAllEntities();
		
		void saveEntity(T entity);
		
		void deleteEntityByID(Long id);
		
		void updateEntity(T entity);
		
		T buildModel(ResultSet rs);
}
