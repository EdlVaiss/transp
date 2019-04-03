package com.senlainc.miliuta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_expenses", catalog = "auto")
public class DriverExpense extends AbstractExpense implements Serializable {

	private static final long serialVersionUID = -1648522807991578078L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drivers_id", nullable = false)
	private Driver driver;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_expense_types_id", nullable = false)
	private DriverExpenseType expenseType;

	public DriverExpense() {
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DriverExpenseType getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(DriverExpenseType expenseType) {
		this.expenseType = expenseType;
	}
}
