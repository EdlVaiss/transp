package com.senlainc.miliuta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_expenses", catalog = "auto")
public class CarExpense extends AbstractExpense implements Serializable {

	private static final long serialVersionUID = -2377223796096933222L;

	@Column(name = "mileage", nullable = false)
	private Integer mileage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cars_id", nullable = false)
	private Car car;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_expense_types_id", nullable = false)
	private CarExpenseType expenseType;

	public CarExpense() {
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarExpenseType getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(CarExpenseType expenseType) {
		this.expenseType = expenseType;
	}
}
