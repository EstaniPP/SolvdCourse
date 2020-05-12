package com.solvd.carFactory.enums;

public enum EmployeeStatus {
	ACTIVE (true,true,1.0),
	ON_LEAVE (false,false,0.0),
	VACATION (false,true,0.5);
	
	private final Boolean working;
	private final Boolean stillInFactory;
	private final Double percentajeAmount;
	
	private EmployeeStatus(Boolean working, Boolean stillInFactory ,Double percentajeAmount) {
		this.working = working;
		this.stillInFactory = stillInFactory; 
		this.percentajeAmount = percentajeAmount;
	}
	
	public Double getPercentajeAmount() {
		return percentajeAmount;
	}
	
	public Boolean isWorking() {
		return working;
	}
	
	public Boolean isStillInFactory() {
		return stillInFactory;
	}
}
