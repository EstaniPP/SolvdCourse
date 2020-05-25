package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IEntityDAO;
import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.Customer;

public class CustomerDAO implements IEntityDAO<Customer>{
	private final static Logger LOGGER = LogManager.getLogger(CustomerDAO.class);
	
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Customers where id = ?");
				ps.setLong(1, id);
				ps.execute();
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
	public ArrayList<Customer> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Customers");
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(buildModel(rs));
				}
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					rs.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}finally {
					try {
						ps.close();
					} catch (SQLException e) {
						LOGGER.error(e);
					}finally {
						conn.releaseConnection(c);
					}
				}
			}
			return list;
	}
	
	@Override
	public Customer getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer obj = new Customer();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Customers where id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				rs.next();
				obj = buildModel(rs);
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					rs.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}finally {
					try {
						ps.close();
					} catch (SQLException e) {
						LOGGER.error(e);
					}finally {
						conn.releaseConnection(c);
					}
				}
			}
			return obj;
	}
	
	@Override
	public void saveEntity(Customer entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Customers (first_name, last_name, email, birth_date) values (?,?,?,?)");
				ps.setString(1, entity.getFirstName());
				ps.setString(2, entity.getLastName());
				ps.setString(3, entity.getEmail());
				ps.setDate(4, entity.getBirthDate());
				ps.execute();
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
	public void updateEntity(Customer entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Customers set first_name = ?, last_name = ?, email = ?, birth_date = ?  where id = ?");
				ps.setString(1, entity.getFirstName());
				ps.setString(2, entity.getLastName());
				ps.setString(3, entity.getEmail());
				ps.setDate(4, entity.getBirthDate());
				ps.setLong(5, entity.getId());
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
	public Customer buildModel(ResultSet rs) {
		Customer obj = new Customer();
		try {
			obj.setId(rs.getLong("id"));
			obj.setBirthDate(rs.getDate("birth_date"));
			obj.setEmail(rs.getString("email"));
			obj.setFirstName(rs.getString("first_name"));
			obj.setLastName(rs.getString("last_name"));
		}catch(Exception e){
			LOGGER.error(e);
		}
		return obj;
	}
	
}