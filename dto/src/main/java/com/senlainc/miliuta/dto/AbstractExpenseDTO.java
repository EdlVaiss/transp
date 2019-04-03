package com.senlainc.miliuta.dto;

import java.time.LocalDate;

import com.senlainc.miliuta.model.AbstractExpense;

public abstract class AbstractExpenseDTO <T extends AbstractExpense> {
	protected Integer id;
	protected LocalDate date;
	protected Integer cost;
	protected String remark;

	public AbstractExpenseDTO() {
		
	}
	
	public AbstractExpenseDTO(Integer id, LocalDate date, Integer cost, String remark) {
		this.id = id;
		this.date = date;
		this.cost = cost;
		this.remark = remark;
	}
	
	public AbstractExpenseDTO(T item) {
		this.id = item.getId();
		this.date = item.getDate();
		this.cost = item.getCost();
		this.remark = item.getRemark();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getCost() {
		return this.cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
