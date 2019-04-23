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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
		result = prime * result + ((expenseType == null) ? 0 : expenseType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriverExpense other = (DriverExpense) obj;
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
			return false;
		if (expenseType == null) {
			if (other.expenseType != null)
				return false;
		} else if (!expenseType.equals(other.expenseType))
			return false;
		return true;
	}
}
