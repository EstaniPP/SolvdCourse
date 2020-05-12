package com.solvd.deliveryCenter.DAO;

import java.util.ArrayList;

public interface IEnitityDAO<T> {
		T getEntityByID(Integer id);
		
		ArrayList<T> getAllEntities();
		
		void saveEntity(T entity);
		
		void deleteEntityByID(Integer id);
		
		void updateEntity(T entity);
}
