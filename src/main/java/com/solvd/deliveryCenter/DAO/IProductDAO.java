package com.solvd.deliveryCenter.DAO;

import java.util.ArrayList;

import com.solvd.deliveryCenter.models.Product;

public interface IProductDAO extends IEntityDAO<Product>{

	ArrayList<Product> getProductsByShopId(Long id);
}
