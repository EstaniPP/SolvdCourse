package com.solvd.carFactory.factoryPersonal;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.carFactory.enums.EmployeePosition;
import com.solvd.carFactory.exceptions.OvertimeCostNotFoundException;

public class WorkerEmployee extends FullTimeEmployee{

	private Integer overtimeHours;
	private Double overtimeCostPerHour;
	private final static Logger LOGGER = LogManager.getLogger(WorkerEmployee.class);
	
	public WorkerEmployee(String name, String lastname, Integer id, Date dateOfBirth, EmployeePosition position, Double salary, String workShift, Integer overtimeHours, Double overtimeCostPerHour) {
		super(name,lastname,id,dateOfBirth,position,salary,workShift);
		this.overtimeCostPerHour = overtimeCostPerHour;
		this.overtimeHours = overtimeHours;
	}
	
	public WorkerEmployee() {
		overtimeHours=0;
	}
	
	@Override
	public Double getSalary() {
		if(overtimeHours>0) {
			try {
				return super.getSalary() + overtimeHours*this.getOvertimeCostPerHour() * super.getStatus().getPercentajeAmount();
			}catch(Exception e){
				LOGGER.error(e);
			}
		}
		return super.getSalary() * super.getStatus().getPercentajeAmount();
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
	
	public void resetOvertimeHours() {
		this.overtimeHours = 0;
	}
}
