package com.solvd.carFactory.poolConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionThread implements Runnable{

	private final static Logger LOGGER = LogManager.getLogger(ConnectionThread.class);
	private String name;
	private ConnectionPool cp;
	
	public ConnectionThread(String name, ConnectionPool cp) {
		this.name = name;
		this.cp = cp;
	}
	
	@Override
	public synchronized void run() {
		String conn = null;
		try {
			conn = cp.getConnection();
		} catch (InterruptedException e) {
			LOGGER.error(e);
		}
		LOGGER.info("Thread:" + name + " connection: " + conn);
		cp.releaseConnection(conn);
	}
	
	
	
}
