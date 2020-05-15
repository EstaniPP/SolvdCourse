package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.ProductInOrder;

public class ProductInOrderDAO implements IEntityDAO<ProductInOrder> {
	private final static Logger LOGGER = LogManager.getLogger(ProductInOrderDAO.class);
	
	public ProductInOrderDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Products_in_orders where id = ?");
				ps.setLong(1, id);
				ps.executeQuery();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
	}
	
	@Override
	public ArrayList<ProductInOrder> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductInOrder> list = new ArrayList<ProductInOrder>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Products_in_orders");
				rs = ps.executeQuery();
				while(rs.next()) {
					ProductInOrder obj = new ProductInOrder();
					obj.setId(rs.getLong("id"));
					obj.setOrderId(rs.getLong("order_id"));
					obj.setProductId(rs.getLong("product_id"));
					obj.setQuantity(rs.getInt("quantity"));
					list.add(obj);
				}
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
			return list;
	}
	
	@Override
	public ProductInOrder getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductInOrder obj = new ProductInOrder();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Products_in_orders where id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				rs.next();
				obj.setId(rs.getLong("id"));
				obj.setOrderId(rs.getLong("order_id"));
				obj.setProductId(rs.getLong("product_id"));
				obj.setQuantity(rs.getInt("quantity"));
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
			return obj;
	}
	
	@Override
	public void saveEntity(ProductInOrder entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Products_in_orders (order_id, product_id, quantity) values (?,?,?)");
				ps.setLong(1, entity.getOrderId());
				ps.setLong(2, entity.getProductId());
				ps.setLong(3, entity.getQuantity());
				ps.executeQuery();
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
	}
	
	@Override
	public void updateEntity(ProductInOrder entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update from Products_in_orders set order_id = ?, description = ?, date = ? where id = ?");
				ps.setLong(1, entity.getOrderId());
				ps.setLong(2, entity.getProductId());
				ps.setLong(3, entity.getQuantity());
				ps.setLong(4, entity.getId());
				ps.executeQuery();
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
	}
	
}
