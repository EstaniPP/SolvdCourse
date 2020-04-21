package com.solvd.carFactory.poolConnection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

	
	private static ConnectionPool cp;
	public static final Integer CONNECTIONSSIZE = 5;
	private BlockingQueue<String> connectionQueue; 
	
	
	private ConnectionPool(){
		initConnections();
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
	
	private void initConnections() {
		connectionQueue = new LinkedBlockingQueue<String>(CONNECTIONSSIZE);
		for(int i=1; i<=CONNECTIONSSIZE; i++) {
			connectionQueue.add(new String("Conn "+i));
		}
	}
	
	public String getConnection() throws InterruptedException{
		return connectionQueue.take();
	}
	
	public void releaseConnection(String s) {
		connectionQueue.add(s);
	}
	

}
