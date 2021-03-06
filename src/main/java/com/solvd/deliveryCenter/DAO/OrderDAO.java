package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.DAO.DAOInterfaces.IOrderDAO;
import com.solvd.deliveryCenter.connectionPool.ConnectionPool;
import com.solvd.deliveryCenter.models.Order;

public class OrderDAO  implements IOrderDAO{

	private final static Logger LOGGER = LogManager.getLogger(OrderDAO.class);
	
	public OrderDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("delete from Orders where id = ?");
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
	public ArrayList<Order> getAllEntities() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Orders");
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
	public Order getEntityByID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order obj = new Order();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Orders where id = ?");
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
	public void saveEntity(Order entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("insert into Orders (vehicle_id, address_id, employee_id, price, date) values (?,?,?,?,?)");
				ps.setLong(1, entity.getVehicleId());
				ps.setLong(2, entity.getAddressId());
				ps.setLong(3, entity.getEmployeeId());
				ps.setLong(4, entity.getPrice());
				ps.setDate(5, entity.getDate());
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
	public void updateEntity(Order entity) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null; 
		PreparedStatement ps = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("update Orders set vehicle_id = ?, address_id = ?, employee_id = ?, price =?, date =? where id = ?");
				ps.setLong(1, entity.getVehicleId());
				ps.setLong(2, entity.getAddressId());
				ps.setLong(3, entity.getEmployeeId());
				ps.setLong(4, entity.getPrice());
				ps.setDate(5, entity.getDate());
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
	public ArrayList<Order> getAllOrdersByAddressID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Orders where address_id = ?");
				ps.setLong(1, id);
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
	public ArrayList<Order> getAllOrdersByVehicleID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Orders where vehicle_id = ?");
				ps.setLong(1, id);
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
	public ArrayList<Order> getAllOrdersByEmployeeID(Long id) {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select * from Orders where employee_id = ?");
				ps.setLong(1, id);
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
	public Order buildModel(ResultSet rs) {
		Order obj = new Order();
		try {
			obj.setId(rs.getLong("id"));
			obj.setVehicleId(rs.getLong("vehicle_id"));
			obj.setAddressId(rs.getLong("address_id"));
			obj.setEmployeeId(rs.getLong("employee_id"));
			obj.setPrice(rs.getInt("price"));
			obj.setDate(rs.getDate("date"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return obj;
	}
}
