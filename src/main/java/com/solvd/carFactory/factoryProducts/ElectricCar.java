package com.solvd.carFactory.factoryProducts;

public class ElectricCar extends Car {
	private Double batteryCapacity;
	private Double timeToChargeInHours;
	
	public Double getBatteryCapacity() {
		return batteryCapacity;
	}
	
	public Double getTimeToChargeInHours() {
		return timeToChargeInHours;
	}
	
	public void setBatteryCapacity(Double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public void setTimeToChargeInHours(Double timeToChargeInHours) {
		this.timeToChargeInHours = timeToChargeInHours;
	}

	@Override
	public void test() {
		//test car
		
	}

	@Override
	public void turnOn() {
		//turnOn
		
	}

	@Override
	public void turnOff() {
		//turnOff
		
	}
	
}
