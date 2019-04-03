package com.senlainc.miliuta.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.CarExpense;
import com.senlainc.miliuta.model.CarExpenseType;

public class CarExpenseTypeDTO extends AbstractExpenseTypeDTO<CarExpenseType>
		implements Serializable, GenericDTO<CarExpenseType> {

	private static final long serialVersionUID = 4590686098449560199L;

	private Set<CarExpense> expenses = new HashSet<>(0);
	
	public CarExpenseTypeDTO() {
	}

	public CarExpenseTypeDTO(CarExpenseType item) {
		super(item);
	}

	public CarExpenseTypeDTO(Integer id, String expenseType) {
		super(id, expenseType);
	}

	public Set<CarExpense> getExpenses() {
		return expenses;
	}


	public void setExpenses(Set<CarExpense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public CarExpenseType toModel() {
		CarExpenseType carExpenseType = new CarExpenseType();
		carExpenseType.setId(id);
		carExpenseType.setExpenseType(expenseType);
		carExpenseType.setCarExpenses(expenses);
		return carExpenseType;
	}
}
