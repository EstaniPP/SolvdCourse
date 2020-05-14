package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.BusinessHourDAO;
import com.solvd.deliveryCenter.DAO.ProductDAO;
import com.solvd.deliveryCenter.DAO.ShopDAO;
import com.solvd.deliveryCenter.models.Product;
import com.solvd.deliveryCenter.models.Shop;

public class ShopService {

	private ShopDAO shopDAO;
	private BusinessHourDAO shopBusinessHours;
	private ProductDAO shopProducts;
	
	public ShopService() {
		shopDAO = new ShopDAO();
		shopBusinessHours = new BusinessHourDAO();
		shopProducts = new ProductDAO();
	}
	
	public ArrayList<Shop> getAllShops() {
		ArrayList<Shop> shops = shopDAO.getAllEntities();
		shops.stream().forEach(shop -> shop.setOpenHours(shopBusinessHours.getHoursByShopId(shop.getId())));
		return shops;
	}
	
	public ArrayList<Product> getShopProducts(Long id){
		return shopProducts.getProductsByShopId(id);
	}
}
