package com.solvd.deliveryCenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.deliveryCenter.connectionPool.ConnectionPool;

public class DBInfoDAO {

	private final static Logger LOGGER = LogManager.getLogger(DBInfoDAO.class);

	public Long getLastID() {
		ConnectionPool conn = ConnectionPool.getInstance();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long id = null;
			try {
				c= conn.getConnection();
				ps = c.prepareStatement("select LAST_INSERT_ID()");
				rs = ps.executeQuery();
				rs.next();
				id = rs.getLong("LAST_INSERT_ID()");
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
			return id;
	}
}
