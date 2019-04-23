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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((expenseType == null) ? 0 : expenseType.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
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
		CarExpense other = (CarExpense) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (expenseType == null) {
			if (other.expenseType != null)
				return false;
		} else if (!expenseType.equals(other.expenseType))
			return false;
		if (mileage == null) {
			if (other.mileage != null)
				return false;
		} else if (!mileage.equals(other.mileage))
			return false;
		return true;
	}
}

