/*
 * NOTE: this runner will throw all exceptions once, if you use the application correctly it
 * wont throw any exception
 * NOTE 2: I had to use LogManager, I searched on the internet because Logger.getLogger(Runner.class) did not 
 * work and it says that I have to use LogManager.getLogger()
 */

package com.solvd.carFactory;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.carFactory.enums.EmployeeStatus;
import com.solvd.carFactory.exceptions.*;
import com.solvd.carFactory.factories.CarFactory;
import com.solvd.carFactory.factories.Department;
import com.solvd.carFactory.factories.PartFactory;
import com.solvd.carFactory.factoryPersonal.Client;
import com.solvd.carFactory.factoryPersonal.EjecutiveEmployee;
import com.solvd.carFactory.factoryPersonal.Employee;
import com.solvd.carFactory.factoryPersonal.WorkerEmployee;
import com.solvd.carFactory.factoryProducts.GasoilCar;
import com.solvd.carFactory.factoryProducts.Order;
import com.solvd.carFactory.factoryProducts.Part;
import com.solvd.carFactory.factoryProducts.Product;
import com.solvd.carFactory.genericsLambda.*;

public class Runner {


	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		//Create car and car part's
		GasoilCar audiA1 = new GasoilCar();
		audiA1.setId(1);
		audiA1.setName("audiA1");
		Part audiA1Motor = new Part();
		audiA1Motor.setPrice(10.0);
		audiA1Motor.setId(2);
		audiA1Motor.setName("audiA1Motor");
		Part audiA1Chasis = new Part();
		
		audiA1Chasis.setPrice(12.0);
		audiA1Chasis.setId(3);
		audiA1Chasis.setName("audiA1Chasis");
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
		

		try {
			carF.addProduct(audiA1);
		}catch(InvalidProductException e){
			LOGGER.error(e);
		}
				
		carF.setProvider(audiA1Chasis,partFChasis);
		carF.setProvider(audiA1Motor,partFMotor);
		
		try {
			partFMotor.addProduct(audiA1Motor);
		}catch(InvalidProductException e){
			LOGGER.error(e);
		}
		
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
		ceo.setName("CEO");
		carF.setDirector(ceo);
		EjecutiveEmployee departmentCeo = new EjecutiveEmployee();
		departmentCeo.setSalary(100.0);
		departmentCeo.setStatus(EmployeeStatus.ACTIVE);
		departmentCeo.setName("DepCeo");
		WorkerEmployee worker = new WorkerEmployee();
		worker.setSalary(90.0);
		worker.setStatus(EmployeeStatus.ACTIVE);
		worker.setName("Worker");
		WorkerEmployee headWorker = new WorkerEmployee();
		headWorker.setSalary(95.0);
		headWorker.setStatus(EmployeeStatus.ACTIVE);
		headWorker.setName("headWorker");
		Department dep = new Department("building", departmentCeo);
		carF.addDepartments(dep);
		dep.addEmployee(worker);
		dep.addEmployee(headWorker);
		dep.setDepartmentDirector(departmentCeo);		
		
		//Generics and lambda
		ArrayList<Employee> employeelist = dep.getEmployees();
		employeelist.add(ceo);
		LOGGER.info(employeelist.toString());
		
		ICompare<Employee> salaryComparator = (firstE, secondE) -> firstE.getSalary() < secondE.getSalary();
		IOrderAndFilter<Employee, ICompare<Employee>> employeeSorter = (employeeList, employeeComparator) ->{
			for(int i=0;i<employeeList.size();i++) {
				for(int j=0;j<employeeList.size()-i-1;j++) {
					if(employeeComparator.compare(employeeList.get(j),employeeList.get(j+1))){
						Employee temp= employeeList.get(j);
						employeeList.set(j,employeeList.get(j+1));
						employeeList.set(j+1,temp);
					}
				}
			}			
		};
		
		ICompare<Employee> nameComparator = (firstE, secondE)-> firstE.getName().compareTo(secondE.getName())>=0; 
		employeeSorter.order(employeelist, nameComparator);
		LOGGER.info(employeelist.toString());
		employeeSorter.order(employeelist, salaryComparator);
		LOGGER.info(employeelist.toString());

		ArrayList<Product> products = new ArrayList<Product>();
		products.add(audiA1Chasis);
		products.add(audiA1Motor);
		products.add(audiA1);
		
		LOGGER.info(products.toString());
		IOrderAndFilter<Product, IFilter<Product>> productFilter = (productList,pFilter) -> {
			ArrayList<Product> toRemove = new ArrayList<Product>();
			for(Product p : productList) {
				if(pFilter.filter(p)) {
					toRemove.add(p);
				}
			}
			products.removeAll(toRemove);
		};
		
		productFilter.order(products, (product)->((Product)product).getPrice() > 11);
		
		LOGGER.info(products.toString());
		
	}
}
