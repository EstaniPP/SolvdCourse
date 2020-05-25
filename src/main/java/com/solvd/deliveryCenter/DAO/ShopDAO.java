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
import com.solvd.deliveryCenter.models.Shop;

public class ShopDAO implements IEntityDAO<Shop>{
	private final static Logger LOGGER = LogManager.getLogger(ShopDAO.class);
	
	public ShopDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Shops where id = ?");
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
	public ArrayList<Shop> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Shop> list = new ArrayList<Shop>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Shops");
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
	public Shop getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Shop obj = new Shop();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Shops where id = ?");
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
	public void saveEntity(Shop entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Shops (company_id, address, phone_number, email) values (?,?,?,?)");
				ps.setLong(1, entity.getCompanyId());
				ps.setString(2, entity.getAddress());
				ps.setString(3, entity.getPhoneNumber());
				ps.setString(4, entity.getEmail());
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
	public void updateEntity(Shop entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Shops set company_id = ?, address = ?, phone_number = ?, email = ? where id = ?");
				ps.setLong(1, entity.getCompanyId());
				ps.setString(2, entity.getAddress());
				ps.setString(3, entity.getPhoneNumber());
				ps.setString(4, entity.getEmail());
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
	public Shop buildModel(ResultSet rs) {
		Shop obj = new Shop();
		try {
			obj.setCompanyId(rs.getLong("company_id"));
			obj.setAddress(rs.getString("address"));
			obj.setPhoneNumber(rs.getString("phone_number"));
			obj.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return obj;
	}
	
}