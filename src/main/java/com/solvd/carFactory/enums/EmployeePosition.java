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
	
	private final Boolean getAccessEmployeeInfo;
	private final Boolean getAccessStockInfo;
	private final Boolean getAccessEconomicInfo;
	private final Boolean getChangeEmployeeInfo;
	private final Boolean getChangeStockInfo;
	private final Boolean getChangeEconomicInfo;
	private final Boolean getProduce;
	
	private EmployeePosition(Boolean getAccessEmployeeInfo,Boolean getAccessStockInfo,Boolean getAccessEconomicInfo,Boolean getChangeEmployeeInfo,Boolean getChangeStockInfo,Boolean getChangeEconomicInfo,Boolean getProduce) {
		this.getAccessEmployeeInfo = getAccessEmployeeInfo;
		this.getAccessStockInfo = getAccessStockInfo;
		this.getAccessEconomicInfo = getAccessEconomicInfo;
		this.getChangeEmployeeInfo = getChangeEmployeeInfo;
		this.getChangeStockInfo = getChangeStockInfo;
		this.getChangeEconomicInfo = getChangeEconomicInfo;
		this.getProduce = getProduce;
	}
	
	public Boolean getAccessEconomicInfo() {
		return getAccessEconomicInfo;
	}
	
	public Boolean getAccessEmployeeInfo() {
		return getAccessEmployeeInfo;
	}
	
	public Boolean getAccessStockInfo() {
		return getAccessStockInfo;
	}
	
	public Boolean getChangeEconomicInfo() {
		return getChangeEconomicInfo;
	}
	
	public Boolean getProduce() {
		return getProduce;
	}
	
	public Boolean getChangeEmployeeInfo() {
		return getChangeEmployeeInfo;
	}
	
	public Boolean getChangeStockInfo() {
		return getChangeStockInfo;
	}	
}
