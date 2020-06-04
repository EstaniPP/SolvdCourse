package com.solvd.deliveryCenter.connectionPool;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SQLSession {

	private static SqlSessionFactory session;
	private final static Logger LOGGER = LogManager.getLogger(SQLSession.class);

	public static SqlSessionFactory getInstance() {
		if(session == null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				LOGGER.error(e);
			}	
			session = new SqlSessionFactoryBuilder().build(inputStream);
		}
		return session;
	}
	
}
