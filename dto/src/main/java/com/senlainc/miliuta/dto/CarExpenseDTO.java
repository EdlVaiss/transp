package com.senlainc.miliuta.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.Car;
import com.senlainc.miliuta.model.CarExpense;
import com.senlainc.miliuta.model.CarExpenseType;

public class CarExpenseDTO extends AbstractExpenseDTO<CarExpense> implements Serializable, GenericDTO<CarExpense> {

	private static final long serialVersionUID = 8082932900881020829L;
	private Integer mileage;
	private Car car;
	private CarExpenseType expenseType;

	public CarExpenseDTO() {
	}

	public CarExpenseDTO(Integer id, Integer mileage, LocalDate date, Integer cost, String remark) {
		super(id, date, cost, remark);
		this.mileage = mileage;
	}

	public CarExpenseDTO(CarExpense item) {
		super(item);
		this.mileage = item.getMileage();
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(CarExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	@Override
	public CarExpense toModel() {
		CarExpense carExpense = new CarExpense();
		carExpense.setId(id);
		carExpense.setMileage(mileage);
		carExpense.setDate(date);
		carExpense.setCost(cost);
		carExpense.setRemark(remark);
		carExpense.setCar(car);
		carExpense.setExpenseType(expenseType);
		return carExpense;
	}
}
