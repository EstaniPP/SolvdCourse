package com.solvd.carFactory.enums;

public enum EmployeePosition {
	PRODUCTION_WORKER(false,false,false,false,false,false,true),
	SENIOR_PRODUCTION_WORKER(false,true,false,false,false,false,true),
	PRODUCTION_WORKER_SPUERVISOR(true,true,false,false,true,false,true),
	DIRECTOR(true,true,true,true,true,true,false),
	CONTROLS_ENGINEER(true,true,false,true,true,false,false),
	COMPUTER_CONTROL_PROGGRAMER(true,true,true,false,false,false,false),
	HUMAN_RESOURCES_EMPLOYEE(true,false,false,true,false,false,false),
	ACCOUNTANT(true,true,true,false,false,true,false);
	
	private final Boolean canAccessEmployeeInfo;
	private final Boolean canAccessStockInfo;
	private final Boolean canAccessEconomicInfo;
	private final Boolean canChangeEmployeeInfo;
	private final Boolean canChangeStockInfo;
	private final Boolean canChangeEconomicInfo;
	private final Boolean canProduce;
	
	private EmployeePosition(Boolean canAccessEmployeeInfo,Boolean canAccessStockInfo,Boolean canAccessEconomicInfo,Boolean canChangeEmployeeInfo,Boolean canChangeStockInfo,Boolean canChangeEconomicInfo,Boolean canProduce) {
		this.canAccessEmployeeInfo = canAccessEmployeeInfo;
		this.canAccessStockInfo = canAccessStockInfo;
		this.canAccessEconomicInfo = canAccessEconomicInfo;
		this.canChangeEmployeeInfo = canChangeEmployeeInfo;
		this.canChangeStockInfo = canChangeStockInfo;
		this.canChangeEconomicInfo = canChangeEconomicInfo;
		this.canProduce = canProduce;
	}
	
	public Boolean canAccessEconomicInfo() {
		return canAccessEconomicInfo;
	}
	
	public Boolean canAccessEmployeeInfo() {
		return canAccessEmployeeInfo;
	}
	
	public Boolean canAccessStockInfo() {
		return canAccessStockInfo;
	}
	
	public Boolean canChangeEconomicInfo() {
		return canChangeEconomicInfo;
	}
	
	public Boolean canProduce() {
		return canProduce;
	}
	
	public Boolean canChangeEmployeeInfo() {
		return canChangeEmployeeInfo;
	}
	
	public Boolean canChangeStockInfo() {
		return canChangeStockInfo;
	}	
}
