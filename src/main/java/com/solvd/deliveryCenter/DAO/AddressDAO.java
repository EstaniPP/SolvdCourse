package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.Address;

public class AddressDAO implements IAddressDAO{

	private final static Logger LOGGER = LogManager.getLogger(AddressDAO.class);
	
	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Addresses where id = ?");
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
	public ArrayList<Address> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Address> addresses = new ArrayList<Address>();
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Addresses");
				rs = ps.executeQuery();
				while(rs.next()) {
					Address a = new Address();
					a.setId(rs.getLong("id"));
					a.setCustomerId(rs.getLong("customer_id"));
					a.setAddress(rs.getString("address"));
					a.setCity(rs.getString("city"));
					a.setEstate(rs.getString("estate"));
					a.setPostalCode(rs.getString("postal_code"));
					addresses.add(a);
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
			return addresses;
	}
	
	@Override
	public Address getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Address a = new Address();
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Addresses where id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				rs.next();
				a.setId(rs.getLong("id"));
				a.setCustomerId(rs.getLong("customer_id"));
				a.setAddress(rs.getString("address"));
				a.setCity(rs.getString("city"));
				a.setEstate(rs.getString("estate"));
				a.setPostalCode(rs.getString("postal_code"));
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
			return a;
	}
	
	@Override
	public void saveEntity(Address entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Addresses (customer_id, address, city, estate, postal_code) values (?,?,?,?,?)");
				ps.setLong(1, entity.getCustomerId());
				ps.setString(2, entity.getAddress());
				ps.setString(3, entity.getCity());
				ps.setString(4, entity.getEstate());
				ps.setString(5, entity.getPostalCode());
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
	public void updateEntity(Address entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("update from Addresses set customer_id = ?, address = ?, city = ?, estate = ?, postal_code = ?  where id = ?");
				ps.setLong(1, entity.getCustomerId());
				ps.setString(2, entity.getAddress());
				ps.setString(3, entity.getCity());
				ps.setString(4, entity.getEstate());
				ps.setString(5, entity.getPostalCode());
				ps.setLong(6, entity.getId());
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
	public ArrayList<Address> getAddressesByCustomerID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Address> addresses = new ArrayList<Address>();
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Addresses where customer_id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					Address a = new Address();
					a.setId(rs.getLong("id"));
					a.setCustomerId(rs.getLong("customer_id"));
					a.setAddress(rs.getString("address"));
					a.setCity(rs.getString("city"));
					a.setEstate(rs.getString("estate"));
					a.setPostalCode(rs.getString("postal_code"));
					addresses.add(a);
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
			return addresses;
	}
	
}
