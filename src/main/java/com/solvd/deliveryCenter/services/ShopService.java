package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.BusinessHourDAO;
import com.solvd.deliveryCenter.DAO.ProductDAO;
import com.solvd.deliveryCenter.DAO.ShopDAO;
import com.solvd.deliveryCenter.models.Product;
import com.solvd.deliveryCenter.models.Shop;

public class ShopService {

	private ShopDAO shopDAO;
	private BusinessHourDAO shopBusinessHoursDAO;
	private ProductDAO shopProductsDAO;
	
	public ShopService() {
		shopDAO = new ShopDAO();
		shopBusinessHoursDAO = new BusinessHourDAO();
		shopProductsDAO = new ProductDAO();
	}
	
	public ArrayList<Shop> getAllShops() {
		ArrayList<Shop> shops = shopDAO.getAllEntities();
		shops.stream().forEach(shop -> shop.setOpenHours(shopBusinessHoursDAO.getHoursByShopId(shop.getId())));
		return shops;
	}
	
	public ArrayList<Product> getShopProducts(Long id){
		return shopProductsDAO.getProductsByShopId(id);
	}
	
	public void deleteShop(Long id) {
		shopDAO.deleteEntityByID(id);
	}
	
	public void updateShop(Shop s) {
		shopDAO.updateEntity(s);
	}
	
	public void saveShop(Shop s) {
		shopDAO.saveEntity(s);
	}
}
