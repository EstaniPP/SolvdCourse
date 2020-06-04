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
import com.solvd.deliveryCenter.models.AdministrativeEmployee;

public class AdministrativeEmployeeDAO implements IEntityDAO<AdministrativeEmployee>{

	private final static Logger LOGGER = LogManager.getLogger(AdministrativeEmployeeDAO.class);
	
	public AdministrativeEmployeeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Administrative_employees where id = ?");
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
	public ArrayList<AdministrativeEmployee> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<AdministrativeEmployee> list = new ArrayList<AdministrativeEmployee>();
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Administrative_employees");
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
	public AdministrativeEmployee getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AdministrativeEmployee obj = new AdministrativeEmployee();
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Administrative_employees where id = ?");
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
	public void saveEntity(AdministrativeEmployee entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Administrative_employees (employee_id, salary) values (?,?)");
				ps.setLong(1, entity.getEmployeeId());
				ps.setDouble(2, entity.getSalary());
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
	public void updateEntity(AdministrativeEmployee entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Administrative_employees set salary = ?  where employee_id = ?");
				ps.setDouble(1, entity.getSalary());
				ps.setLong(2, entity.getId());
				ps.executeUpdate();
				ps.close();
			} catch (InterruptedException e) {
				LOGGER.error(e);
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				conn.releaseConnection(c);
			}
	}

	@Override
	public AdministrativeEmployee buildModel(ResultSet rs) {
		AdministrativeEmployee a = new AdministrativeEmployee();
		try {
			a.setEmployeeId(rs.getLong("employee_id"));
			a.setSalary(rs.getDouble("salary"));
		}catch(Exception e){
			LOGGER.error(e);
		}
		return a;
	}
	
}
