package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IBusinessHourDAO;
import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.BusinessHour;

public class BusinessHourDAO implements IBusinessHourDAO {
	
	private final static Logger LOGGER = LogManager.getLogger(BusinessHourDAO.class);
	
	public BusinessHourDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Business_hours where id = ?");
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
	public ArrayList<BusinessHour> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BusinessHour> list = new ArrayList<BusinessHour>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Business_hours");
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
	public BusinessHour getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BusinessHour obj = new BusinessHour();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Business_hours where id = ?");
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
	public void saveEntity(BusinessHour entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Business_hours (shop_id, day, hour) values (?,?,?)");
				ps.setLong(1, entity.getShopId());
				ps.setString(2, entity.getDay());
				ps.setTime(3, entity.getHour());
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
	public void updateEntity(BusinessHour entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Business_hours set shop_id = ?, day = ?, hour = ?  where id = ?");
				ps.setLong(1, entity.getShopId());
				ps.setString(2, entity.getDay());
				ps.setTime(3, entity.getHour());
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

	@Override
	public ArrayList<BusinessHour> getHoursByShopId(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BusinessHour> list = new ArrayList<BusinessHour>();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Business_hours where shop_id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(buildModel(rs));
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
	public BusinessHour buildModel(ResultSet rs) {
		BusinessHour obj = new BusinessHour();
		try {
			obj.setId(rs.getLong("id"));
			obj.setShopId(rs.getLong("shop_id"));
			obj.setDay(rs.getString("day"));
			obj.setHour(rs.getTime("hour"));
		}catch(Exception e){
			LOGGER.error(e);
		}
		return obj;
	}
	
}
