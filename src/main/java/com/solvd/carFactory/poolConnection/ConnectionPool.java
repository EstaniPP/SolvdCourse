package com.solvd.carFactory.poolConnection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

	
	private static ConnectionPool cp;
	public static final Integer CONNECTIONS_SIZE = 5;
	private BlockingQueue<String> connectionQueue;
	private Integer connectionsCreated;
	
	
	private ConnectionPool(){
		connectionQueue = new LinkedBlockingQueue<String>(CONNECTIONS_SIZE);
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
		connectionQueue.add(new String("Conn "+(++connectionsCreated)));
	}
	
	public String getConnection() throws InterruptedException{
		if(connectionQueue.size() > 0) {
			return connectionQueue.take();
		}
		if(connectionsCreated < CONNECTIONS_SIZE) {
			initConnection();
		}
		return connectionQueue.take();
	}
	
	public void releaseConnection(String s) {
		connectionQueue.add(s);
	}
	

}
