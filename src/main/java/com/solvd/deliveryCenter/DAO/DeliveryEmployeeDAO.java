package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.DeliveryEmployee;

public class DeliveryEmployeeDAO implements IEnitityDAO<DeliveryEmployee> {
	private final static Logger LOGGER = LogManager.getLogger(DeliveryEmployeeDAO.class);
	
	public DeliveryEmployeeDAO() {
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
				ps = c.prepareStatement("delete from Delivery_employees where id = ?");
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
	public ArrayList<DeliveryEmployee> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<DeliveryEmployee> list = new ArrayList<DeliveryEmployee>();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Delivery_employees");
				rs = ps.executeQuery();
				while(rs.next()) {
					DeliveryEmployee obj = new DeliveryEmployee();
					obj.setId(rs.getLong("employee_id"));
					obj.setLicense(rs.getString("drivers_license"));
					obj.setDeliveryFee(rs.getLong("delivery_fee"));
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
	public DeliveryEmployee getEntityByID(Integer id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DeliveryEmployee obj = new DeliveryEmployee();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Delivery_employees where id = ?");
				ps.setString(1, id.toString());
				rs = ps.executeQuery();
				rs.next();
				obj.setId(rs.getLong("employee_id"));
				obj.setLicense(rs.getString("drivers_license"));
				obj.setDeliveryFee(rs.getLong("delivery_fee"));
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
	public void saveEntity(DeliveryEmployee entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Delivery_employees (delivery_fee, drivers_license) values (?,?)");
				ps.setString(1, entity.getDeliveryFee().toString());
				ps.setString(2, entity.getLicense().toString());
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
	public void updateEntity(DeliveryEmployee entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("update from Delivery_employees set delivery_fee = ?, drivers_license = ? where employee_id = ?");
				ps.setString(1, entity.getDeliveryFee().toString());
				ps.setString(2, entity.getLicense().toString());
				ps.setString(3, entity.getEmployeeId().toString());
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