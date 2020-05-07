package com.solvd.carFactory.poolConnection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PoolConnectionRunner {

	private final static Logger LOGGER = LogManager.getLogger(PoolConnectionRunner.class);
	public static void main(String[] args) {
		ConnectionPool cp = ConnectionPool.getInstance();
		ExecutorService executor = Executors.newFixedThreadPool(7);
		for(int i=0; i < 7; i++) {
			executor.execute(new ConnectionThread("Thread "+ i, cp));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}
		LOGGER.info("Finish");
	}
	
}
