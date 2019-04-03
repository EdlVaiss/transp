package com.senlainc.miliuta.dto;

import com.senlainc.miliuta.model.AbstractExpenseType;

public abstract class AbstractExpenseTypeDTO<T extends AbstractExpenseType> {
	protected Integer id;
	protected String expenseType;

	public AbstractExpenseTypeDTO() {
	}

	public AbstractExpenseTypeDTO(Integer id, String expenseType) {
		this.id = id;
		this.expenseType = expenseType;
	}
	
	public AbstractExpenseTypeDTO(T item) {
		this.id = item.getId();
		this.expenseType = item.getExpenseType();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

}
