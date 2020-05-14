package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.CostumerPhoneNumber;

public class CostumerPhoneNumberDAO implements IEnitityDAO<CostumerPhoneNumber> {
	private final static Logger LOGGER = LogManager.getLogger(CostumerPhoneNumberDAO.class);
	
	public CostumerPhoneNumberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Integer id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Costumer_phone_numbers where id = ?");
				ps.setString(1, id.toString());
				ps.executeQuery();
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} catch (InstantiationException e) {
				LOGGER.error(e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e);
			} catch (ClassNotFoundException e) {
				LOGGER.error(e);
			} finally {
				conn.releaseConnection(c);
			}
	}
	
	@Override
	public ArrayList<CostumerPhoneNumber> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CostumerPhoneNumber> list = new ArrayList<CostumerPhoneNumber>();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Costumer_phone_numbers");
				rs = ps.executeQuery();
				while(rs.next()) {
					CostumerPhoneNumber obj = new CostumerPhoneNumber();
					obj.setId(rs.getLong("id"));
					obj.setCostumerId(rs.getLong("costumer_id"));
					obj.setPhones(rs.getString("phone"));
					list.add(obj);
				}
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} catch (InstantiationException e) {
				LOGGER.error(e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e);
			} catch (ClassNotFoundException e) {
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
	public CostumerPhoneNumber getEntityByID(Integer id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CostumerPhoneNumber obj = new CostumerPhoneNumber();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Costumer_phone_numbers where id = ?");
				ps.setString(1, id.toString());
				rs = ps.executeQuery();
				rs.next();
				obj.setId(rs.getLong("id"));
				obj.setCostumerId(rs.getLong("costumer_id"));
				obj.setPhones(rs.getString("phone"));
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} catch (InstantiationException e) {
				LOGGER.error(e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e);
			} catch (ClassNotFoundException e) {
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
	public void saveEntity(CostumerPhoneNumber entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Costumer_phone_numbers (phone, costumer_id) values (?,?)");
				ps.setString(1, entity.getPhones().toString());
				ps.setString(2, entity.getCostumerId().toString());
				ps.executeQuery();
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} catch (InstantiationException e) {
				LOGGER.error(e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e);
			} catch (ClassNotFoundException e) {
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
	public void updateEntity(CostumerPhoneNumber entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("update from Costumer_phone_numbers set order_id = ?, description = ?, date = ? where id = ?");
				ps.setString(1, entity.getPhones().toString());
				ps.setString(2, entity.getCostumerId().toString());
				ps.setString(3, entity.getId().toString());
				ps.executeQuery();
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			} catch (InstantiationException e) {
				LOGGER.error(e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e);
			} catch (ClassNotFoundException e) {
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
