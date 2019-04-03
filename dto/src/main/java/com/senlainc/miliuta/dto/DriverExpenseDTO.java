package com.senlainc.miliuta.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.Driver;
import com.senlainc.miliuta.model.DriverExpense;
import com.senlainc.miliuta.model.DriverExpenseType;

public class DriverExpenseDTO extends AbstractExpenseDTO<DriverExpense> implements Serializable, GenericDTO<DriverExpense> {

	private static final long serialVersionUID = 6553756539983764882L;

	private Driver driver;
	private DriverExpenseType expenseType;
	
	public DriverExpenseDTO() {
	}

	public DriverExpenseDTO(Integer id, LocalDate date, Integer cost, String remark) {
		super(id, date, cost, remark);
	}
	
	public DriverExpenseDTO(DriverExpense item) {
		super(item);
	}
	
		public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DriverExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(DriverExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	@Override
	public DriverExpense toModel() {
		DriverExpense driverExpense = new DriverExpense();
		driverExpense.setId(id);
		driverExpense.setDate(date);
		driverExpense.setCost(cost);
		driverExpense.setRemark(remark);
		driverExpense.setDriver(driver);
		driverExpense.setExpenseType(expenseType);
		return driverExpense;
	}

}