package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IBusinessHourDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.ICompanyDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IProductDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IShopDAO;
import com.solvd.deliveryCenter.connectionPool.SQLSession;
import com.solvd.deliveryCenter.models.Product;
import com.solvd.deliveryCenter.models.Shop;

public class ShopService {

	private IShopDAO shopDAO;
	private IBusinessHourDAO shopBusinessHoursDAO;
	private IProductDAO shopProductsDAO;
	private ICompanyDAO companyDAO;
	
	public ShopService() {
		shopDAO = SQLSession.getInstance().openSession(true).getMapper(IShopDAO.class);
		shopBusinessHoursDAO = SQLSession.getInstance().openSession(true).getMapper(IBusinessHourDAO.class);
		shopProductsDAO =  SQLSession.getInstance().openSession(true).getMapper(IProductDAO.class);
		companyDAO = SQLSession.getInstance().openSession(true).getMapper(ICompanyDAO.class);
	}
	
	public ArrayList<Shop> getAllShops() {
		ArrayList<Shop> shops = shopDAO.getAllEntities();
		shops.stream().forEach(shop -> shop.setOpenHours(shopBusinessHoursDAO.getHoursByShopId(shop.getId())));
		shops.stream().forEach(shop -> shop.setCompany(companyDAO.getEntityByID(shop.getCompanyId())));
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
