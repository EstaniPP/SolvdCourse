package com.solvd.carFactory.factories;

import java.util.HashMap;

import com.solvd.carFactory.exceptions.CarNoPartsException;
import com.solvd.carFactory.exceptions.CarNotFoundException;
import com.solvd.carFactory.exceptions.PartFactoryNotFoundException;
import com.solvd.carFactory.exceptions.PartNotFoundException;
import com.solvd.carFactory.exceptions.InvalidProductException;
import com.solvd.carFactory.factoryPersonal.EjecutiveEmployee;
import com.solvd.carFactory.factoryPersonal.IReceive;
import com.solvd.carFactory.factoryProducts.Car;
import com.solvd.carFactory.factoryProducts.Order;
import com.solvd.carFactory.factoryProducts.Part;
import com.solvd.carFactory.factoryProducts.Product;

public class CarFactory extends Factory implements IReceive{

	private HashMap<Product, Integer> inventory;//(product, quantity)
	private HashMap<Product, PartFactory> providers;//(prductId, partFactory which produces it)
	private String name;
	
	public CarFactory(String name, EjecutiveEmployee director, String phone) {
		super(name, director, phone);
		this.inventory = new HashMap<Product, Integer>();
		this.providers = new HashMap<Product, PartFactory>();
	}
	
	public CarFactory() {
		this.inventory = new HashMap<Product, Integer>();
		this.providers = new HashMap<Product, PartFactory>();
	}

	@Override
	public void produce(Order o) throws CarNotFoundException, PartFactoryNotFoundException, CarNoPartsException, PartNotFoundException{
		Boolean exists = false;
		Car car = null;
		for(Product p : this.getProducts()) {
			if(p.getId() == o.getProduct()) {
				car = (Car) p;
				exists = true;
				break;
			}
		}
		if(exists == false) {throw new CarNotFoundException();}
		//make sure factory has all the needed parts
		for(Part p : car.getCarParts()) {
			if(!inventory.containsKey(p)) {
				if(!providers.containsKey(p)) {
					throw new PartFactoryNotFoundException();
				}else{ 
					providers.get(p).produce(new Order(p.getId(),this,o.getQuantity()));
				}
			}else if(inventory.get(p)<= o.getQuantity()) {
				if(!providers.containsKey(p)) {
					throw new PartFactoryNotFoundException();
				}else {
					providers.get(p).produce(new Order(p.getId(),this,o.getQuantity()-inventory.get(p)));
				}
			}
		}
		
		//build the cars
		for(Part p : car.getCarParts()) {
			inventory.put(p, inventory.get(p)-o.getQuantity());
		}
		
		o.getClient().receive(car, o.getQuantity());
		
	}
	
	public HashMap<Product, PartFactory> getProviders() {
		return providers;
	}
	
	public void setProvider(Product product, PartFactory provider) {
		this.providers.put(product, provider);
	}
	
	public HashMap<Product, Integer> getInventory() {
		return inventory;
	}

	@Override
	public void receive(Product product, Integer quantity) {
		if(inventory.containsKey(product)) {
			inventory.put(product, inventory.get(product)+quantity);
		}else {
			inventory.put(product, quantity);
		}		
	}

	@Override
	public void addProduct(Product product) throws InvalidProductException {
		if(product instanceof Car) {
			super.getProducts().add(product);
		}else {
			throw new InvalidProductException();
		}
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
