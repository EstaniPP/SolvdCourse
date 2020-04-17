/*
 * NOTE: this runner will throw all exceptions once, if you use the application correctly it
 * wont throw any exception
 * NOTE 2: I had to use LogManager, I searched on the internet because Logger.getLogger(Runner.class) did not 
 * work and it says that I have to use LogManager.getLogger()
 */

package com.solvd.carFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.carFactory.enums.EmployeeStatus;
import com.solvd.carFactory.exceptions.*;
import com.solvd.carFactory.factories.CarFactory;
import com.solvd.carFactory.factories.Department;
import com.solvd.carFactory.factories.PartFactory;
import com.solvd.carFactory.factoryPersonal.Client;
import com.solvd.carFactory.factoryPersonal.EjecutiveEmployee;
import com.solvd.carFactory.factoryPersonal.WorkerEmployee;
import com.solvd.carFactory.factoryProducts.GasoilCar;
import com.solvd.carFactory.factoryProducts.Order;
import com.solvd.carFactory.factoryProducts.Part;

public class Runner {


	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		//Create car and car part's
		GasoilCar audiA1 = new GasoilCar();
		audiA1.setId(1);
		//Get price exception
		audiA1.getPrice();//Throws exception
		Part audiA1Motor = new Part();
		audiA1Motor.setPrice(10.0);
		audiA1Motor.setId(2);
		Part audiA1Chasis = new Part();
		audiA1Chasis.setPrice(12.0);
		audiA1Chasis.setId(3);
		audiA1.addCarPart(audiA1Chasis);
		audiA1.addCarPart(audiA1Motor);
		//Car price 
		audiA1.getPrice();
		
		//Create factories
		PartFactory partFMotor = new PartFactory();
		
		
		PartFactory partFChasis = new PartFactory();
		try {
			partFChasis.addProduct(audiA1Chasis);
		}catch(InvalidProductException e){
			LOGGER.error(e);
		}
		
		Client client = new Client();
		Order order = new Order(1, client, 100);
		CarFactory carF = new CarFactory();
		
		//First exception
		try {
			carF.produce(order);
		} catch (PartFactoryNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNoPartsException e) {
			LOGGER.error(e);
		} catch (PartNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNotFoundException e) {
			LOGGER.error(e);
		}
		
		try {
			carF.addProduct(audiA1);
		}catch(InvalidProductException e){
			LOGGER.error(e);
		}
		
		//Second exception
		try {
			carF.produce(order);
		} catch (PartFactoryNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNoPartsException e) {
			LOGGER.error(e);
		} catch (PartNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNotFoundException e) {
			LOGGER.error(e);
		}
		
		carF.setProvider(audiA1Chasis,partFChasis);
		carF.setProvider(audiA1Motor,partFMotor);
		
		//Third exception
		try {
			carF.produce(order);
		} catch (PartFactoryNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNoPartsException e) {
			LOGGER.error(e);
		} catch (PartNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNotFoundException e) {
			LOGGER.error(e);
		}	
		
		try {
			partFMotor.addProduct(audiA1Motor);
			partFMotor.addProduct(audiA1);
		}catch(InvalidProductException e){
			LOGGER.error(e);
		}
		
		//Finally produce
		try {
			carF.produce(order);
		} catch (PartFactoryNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNoPartsException e) {
			LOGGER.error(e);
		} catch (PartNotFoundException e) {
			LOGGER.error(e);
		} catch (CarNotFoundException e) {
			LOGGER.error(e);
		}	
		
		//Assign employees and departments to factories and ask for salaries
		EjecutiveEmployee ceo = new EjecutiveEmployee();
		ceo.setSalary(1000.0);
		ceo.setStatus(EmployeeStatus.ACTIVE);
		carF.setDirector(ceo);
		EjecutiveEmployee departmentCeo = new EjecutiveEmployee();
		departmentCeo.setSalary(100.0);
		departmentCeo.setStatus(EmployeeStatus.ACTIVE);
		WorkerEmployee worker = new WorkerEmployee();
		worker.setSalary(90.0);
		worker.addOvertimeHours(100);
		worker.setStatus(EmployeeStatus.ACTIVE);
		Department dep = new Department("building", departmentCeo);
		carF.addDepartments(dep);
		dep.addEmployee(worker);
		dep.setDepartmentDirector(departmentCeo);
		
		//Last exception
		dep.calculateSalaries();
		worker.resetOvertimeHours();
		LOGGER.info("Total department salaries: "+dep.calculateSalaries());
		LOGGER.info("Total factory employees: "+carF.getEmployeesQuantity());
		
		
	}
}
