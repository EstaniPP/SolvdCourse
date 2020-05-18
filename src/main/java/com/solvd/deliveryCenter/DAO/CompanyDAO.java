package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.Company;

public class CompanyDAO implements IEntityDAO<Company>{
	private final static Logger LOGGER = LogManager.getLogger(CompanyDAO.class);
	
	public CompanyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Companies where id = ?");
				ps.setLong(1, id);
				ps.executeUpdate();
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
	public ArrayList<Company> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Company> list = new ArrayList<Company>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Companies");
				rs = ps.executeQuery();
				while(rs.next()) {
					Company obj = new Company();
					obj.setId(rs.getLong("id"));
					obj.setEmail(rs.getString("email"));
					obj.setName(rs.getString("name"));
					obj.setPhoneNumber(rs.getString("phone_number"));
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
	public Company getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Company obj = new Company();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Companies where id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				rs.next();
				obj.setId(rs.getLong("id"));
				obj.setEmail(rs.getString("email"));
				obj.setName(rs.getString("name"));
				obj.setPhoneNumber(rs.getString("phone_number"));
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
	public void saveEntity(Company entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Companies (name, phone_number, email) values (?,?,?)");
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getPhoneNumber());
				ps.setString(3, entity.getEmail());
				ps.executeUpdate();
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
	public void updateEntity(Company entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update from Companies set name = ?, phone_number = ?, email = ? where id = ?");
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getPhoneNumber());
				ps.setString(3, entity.getEmail());
				ps.setLong(4, entity.getId());
				ps.executeUpdate();
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
