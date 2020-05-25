package com.solvd.deliveryCenter.services;

import java.util.ArrayList;

import com.solvd.deliveryCenter.DAO.BusinessHourDAO;
import com.solvd.deliveryCenter.DAO.CompanyDAO;
import com.solvd.deliveryCenter.DAO.ProductDAO;
import com.solvd.deliveryCenter.DAO.ShopDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IBusinessHourDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEntityDAO;
import com.solvd.deliveryCenter.DAO.DAOInterfaces.IProductDAO;
import com.solvd.deliveryCenter.models.Company;
import com.solvd.deliveryCenter.models.Product;
import com.solvd.deliveryCenter.models.Shop;

public class ShopService {

	private IEntityDAO<Shop> shopDAO;
	private IBusinessHourDAO shopBusinessHoursDAO;
	private IProductDAO shopProductsDAO;
	private IEntityDAO<Company> companyDAO;
	
	public ShopService() {
		shopDAO = new ShopDAO();
		shopBusinessHoursDAO = new BusinessHourDAO();
		shopProductsDAO = new ProductDAO();
		companyDAO = new CompanyDAO();
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
