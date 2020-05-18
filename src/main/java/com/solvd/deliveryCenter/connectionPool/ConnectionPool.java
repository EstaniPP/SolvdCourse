package com.solvd.deliveryCenter.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

	private final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	
	private static ConnectionPool cp;
	private Integer connectionsSize = 5;
	private BlockingQueue<Connection> connectionQueue;
	private Integer connectionsCreated;
	private String url = "jdbc:mysql://127.0.0.1:33060/mydb?useSSL=false";
	private String user = "root";
	private String password = "1111";

	private ConnectionPool(){
		connectionQueue = new LinkedBlockingQueue<Connection>(connectionsSize);
		connectionsCreated = 0;
	}

	public static ConnectionPool getInstance(){
		if(cp == null) {
			synchronized(ConnectionPool.class) {
				if(cp == null){
					cp = new ConnectionPool();
				}
			}
		}
		return cp;
	}
	
	private void initConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connectionQueue.add(DriverManager.getConnection(url,user,password));
			connectionsCreated++;
		} catch (SQLException e) {
			LOGGER.error(e);
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		}
	}
	
	public Connection getConnection() throws InterruptedException{
		if(connectionQueue.size() > 0) {
			return connectionQueue.take();
		}
		if(connectionsCreated < connectionsSize) {
			synchronized(ConnectionPool.class) {
				if(connectionsCreated < connectionsSize) initConnection();
			}
		}
		return connectionQueue.take();
	}
	
	public void releaseConnection(Connection c) {
		connectionQueue.add(c);
	}
	

}