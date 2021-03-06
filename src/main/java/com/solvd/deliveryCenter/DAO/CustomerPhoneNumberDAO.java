package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.ICustomerPhoneNumberDAO;
import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.CustomerPhoneNumber;

public class CustomerPhoneNumberDAO implements ICustomerPhoneNumberDAO {
	private final static Logger LOGGER = LogManager.getLogger(CustomerPhoneNumberDAO.class);
	
	public CustomerPhoneNumberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Customer_phone_numbers where id = ?");
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
	public ArrayList<CustomerPhoneNumber> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerPhoneNumber> list = new ArrayList<CustomerPhoneNumber>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Customer_phone_numbers");
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
	public CustomerPhoneNumber getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerPhoneNumber obj = new CustomerPhoneNumber();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Customer_phone_numbers where id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				rs.next();
				obj= buildModel(rs);
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
	public void saveEntity(CustomerPhoneNumber entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Customer_phone_numbers (phone, customer_id) values (?,?)");
				ps.setString(1, entity.getPhones());
				ps.setLong(2, entity.getCustomerId());
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
	public void updateEntity(CustomerPhoneNumber entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Customer_phone_numbers set phone = ?, employee_id = ? where id = ?");
				ps.setString(1, entity.getPhones());
				ps.setLong(2, entity.getCustomerId());
				ps.setLong(3, entity.getId());
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
	public ArrayList<CustomerPhoneNumber> getPhonesByCustomerID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerPhoneNumber> list = new ArrayList<CustomerPhoneNumber>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Customer_phone_numbers where customer_id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					CustomerPhoneNumber obj = new CustomerPhoneNumber();
					obj.setId(rs.getLong("id"));
					obj.setCustomerId(rs.getLong("customer_id"));
					obj.setPhoneNumber(rs.getString("phone"));
					list.add(obj);
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
	public CustomerPhoneNumber buildModel(ResultSet rs) {
		CustomerPhoneNumber obj = new CustomerPhoneNumber();
		try {
			obj.setId(rs.getLong("id"));
			obj.setCustomerId(rs.getLong("customer_id"));
			obj.setPhoneNumber(rs.getString("phone"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return obj;
	}
	
}
