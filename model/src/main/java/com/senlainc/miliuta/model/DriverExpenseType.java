package com.senlainc.miliuta.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "driver_expense_types", catalog = "auto")
public class DriverExpenseType extends AbstractExpenseType implements Serializable {

	private static final long serialVersionUID = 4260579454996972968L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseType", cascade = CascadeType.ALL)
	private Set<DriverExpense> expenses = new HashSet<>(0);

	public DriverExpenseType() {
	}

	public Set<DriverExpense> getDriverExpenseses() {
		return this.expenses;
	}

	public void setDriverExpenseses(Set<DriverExpense> driverExpenseses) {
		this.expenses = driverExpenseses;
	}
}
