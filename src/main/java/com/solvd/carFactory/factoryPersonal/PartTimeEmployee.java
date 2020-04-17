package com.solvd.carFactory.factoryPersonal;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.carFactory.enums.EmployeePosition;
import com.solvd.carFactory.exceptions.OvertimeCostNotFoundException;

public class PartTimeEmployee extends Employee {
	
	private Integer overtimeHours;
	private Double overtimeCostPerHour;
	private final static Logger LOGGER = LogManager.getLogger(PartTimeEmployee.class);
	
	public PartTimeEmployee() {
		overtimeHours=0;
	}
	
	public PartTimeEmployee(String name, String lastname, Integer id, Date dateOfBirth, EmployeePosition position, Integer overtimeHours, Double overtimeCostPerHour) {
		super(name,lastname,id,dateOfBirth,position);
		this.overtimeCostPerHour = overtimeCostPerHour;
		this.overtimeHours = overtimeHours;
	}
	
	@Override
	public Double getSalary() {
		if(overtimeHours>0) {
			try {
				return overtimeHours*this.getOvertimeCostPerHour()* super.getStatus().getPercentajeAmount();
			}catch(Exception e){
				LOGGER.error(e);
			}
		}
		return 0.0;
	}
	
	public Double getOvertimeCostPerHour() throws Exception {
		if(overtimeCostPerHour == null) {
			throw new OvertimeCostNotFoundException();
		}
		return overtimeCostPerHour;
	}
	
	public void setOvertimeCostPerHour(Double overtimeCostPerHour) {
		this.overtimeCostPerHour = overtimeCostPerHour;
	}
	
	public Integer getOvertimeHours() {
		return overtimeHours;
	}
	
	public void addOvertimeHours(Integer overtimeHours) {
		this.overtimeHours+=overtimeHours;
	}
	
	public void resetOvertimeHours(Integer overtimeHours) {
		this.overtimeHours = 0;
	}
}
