package com.solvd.carFactory.linkedListPackage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedListRunner {

	private final static Logger LOGGER = LogManager.getLogger(LinkedListRunner.class);
	
	public static void main(String[] args) {

		LinkedList s = new LinkedList();
		s.add(5);
		s.add(0, "Hola");
		s.add(2,2);
		s.add(1000);
		LOGGER.info(s.toString());
		LOGGER.info(s.toStringReverse());
		LOGGER.info(s.get(2));
		s.removeAt(1);
		LOGGER.info(s.toString());
		LOGGER.info(s.toStringReverse());
		LOGGER.info(s.get(2));
		s.add(5);
		s.add(0, "Hola");
		s.add(2,2);
		s.add(1000);
		LOGGER.info(s.toString());
		LOGGER.info(s.toStringReverse());
		LOGGER.info(s.get(2));
		s.removeObj("Hola");
		LOGGER.info(s.toString());
		LOGGER.info(s.toStringReverse());
		LOGGER.info(s.get(2));
	}
}
