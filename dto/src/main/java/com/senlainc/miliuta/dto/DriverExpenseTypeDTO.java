package com.senlainc.miliuta.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.DriverExpense;
import com.senlainc.miliuta.model.DriverExpenseType;

public class DriverExpenseTypeDTO extends AbstractExpenseTypeDTO<DriverExpenseType>
		implements Serializable, GenericDTO<DriverExpenseType> {

	private static final long serialVersionUID = -714676055512511600L;

	private Set<DriverExpense> expenses = new HashSet<>(0);
	
	public DriverExpenseTypeDTO() {
	}

	public DriverExpenseTypeDTO(DriverExpenseType item) {
		super(item);
	}

	public DriverExpenseTypeDTO(Integer id, String expenseType) {
		super(id, expenseType);
	}

	public Set<DriverExpense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<DriverExpense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public DriverExpenseType toModel() {
		DriverExpenseType driverExpenseType = new DriverExpenseType();
		driverExpenseType.setId(id);
		driverExpenseType.setExpenseType(expenseType);
		driverExpenseType.setDriverExpenseses(expenses);
		return driverExpenseType;
	}
}
