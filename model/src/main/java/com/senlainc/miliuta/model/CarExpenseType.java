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
@Table(name = "car_expense_types", catalog = "auto")
public class CarExpenseType extends AbstractExpenseType
		implements Serializable {

	private static final long serialVersionUID = 4260579454996972968L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseType", cascade = CascadeType.ALL)
	private Set<CarExpense> expenses = new HashSet<>(0);
	
	public CarExpenseType() {
	}

	public Set<CarExpense> getCarExpenses() {
		return this.expenses;
	}

	public void setCarExpenses(Set<CarExpense> carExpenses) {
		this.expenses = carExpenses;
	}
}
