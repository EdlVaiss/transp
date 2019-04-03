package com.senlainc.miliuta.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.Car;
import com.senlainc.miliuta.model.CarExpense;
import com.senlainc.miliuta.model.Driver;

public class CarDTO implements Serializable, GenericDTO<Car> {

	private static final long serialVersionUID = 1975728690716058554L;

	private Integer id;
	private String registrationNumber;
	private String brand;
	private String model;
	private Set<Driver> drivers = new HashSet<>(0);
	private Set<CarExpense> carExpenses = new HashSet<>(0);
	
	public CarDTO() {
	}

	public CarDTO(Integer id, String registrationNumber, String brand, String model) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.model = model;
	}
	
	public CarDTO(Car item) {
		this.id = item.getId();
		this.registrationNumber = item.getRegistrationNumber();
		this.brand = item.getBrand();
		this.model = item.getModel();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Set<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}

	public Set<CarExpense> getCarExpenses() {
		return carExpenses;
	}

	public void setCarExpenses(Set<CarExpense> carExpenses) {
		this.carExpenses = carExpenses;
	}

	@Override
	public Car toModel() {
		Car car = new Car();
		car.setId(id);
		car.setRegistrationNumber(registrationNumber);
		car.setBrand(brand);
		car.setModel(model);
		car.setDrivers(drivers);
		car.getCarExpenses();
		return car;
	}
}
