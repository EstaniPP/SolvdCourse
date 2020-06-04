package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IDepartmentDAO;
import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.Department;

public class DepartmentDAO implements IDepartmentDAO{

	private final static Logger LOGGER = LogManager.getLogger(DepartmentDAO.class);
	
	public DepartmentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Departments where id = ?");
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
	public ArrayList<Department> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Department> list = new ArrayList<Department>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Departments");
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
	public Department getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department obj = new Department();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Departments where id = ?");
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
	public void saveEntity(Department entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				if(entity.getCeoId() != null) {
					ps = c.prepareStatement("insert into Departments (especialization, address, phone_number, email, ceo_id) values (?,?,?,?,?)");
					ps.setLong(5, entity.getCeoId());
				}else {
					ps = c.prepareStatement("insert into Departments (especialization, address, phone_number, email) values (?,?,?,?)");
				}
				ps.setString(1, entity.getEspecialization());
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
	public void updateEntity(Department entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Departments set especialization = ?, address = ?, phone_number = ?, email = ?, ceo_id = ?  where id = ?");
				ps.setString(1, entity.getEspecialization());
				ps.setString(2, entity.getAddress());
				ps.setString(3, entity.getPhoneNumber());
				ps.setString(4, entity.getEmail());
				ps.setLong(5, entity.getCeoId());
				ps.setLong(6, entity.getId());
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
	public Department buildModel(ResultSet rs) {
		Department obj = new Department();
		try {
			obj.setId(rs.getLong("id"));
			obj.setEspecialization(rs.getString("especialization"));
			obj.setAddress(rs.getString("address"));
			obj.setPhoneNumber(rs.getString("phone_number"));
			obj.setEmail(rs.getString("email"));
			obj.setCeoId(rs.getLong("ceo_id"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return obj;
	}
	
}
