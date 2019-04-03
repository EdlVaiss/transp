package com.senlainc.miliuta.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.Car;
import com.senlainc.miliuta.model.Driver;
import com.senlainc.miliuta.model.DriverExpense;

public class DriverDTO implements Serializable, GenericDTO<Driver> {

	private static final long serialVersionUID = -3343158014639526134L;
	
	private Integer id;
	private String name;
	private String phone;
	private Set<Car> cars = new HashSet<>(0);
	private Set<DriverExpense> driverExpenses = new HashSet<>(0);
	
	public DriverDTO() {
	}

	public DriverDTO(Integer id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public DriverDTO(Driver item) {
		this.id = item.getId();
		this.name = item.getName();
		this.phone = item.getPhone();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Set<DriverExpense> getDriverExpenses() {
		return driverExpenses;
	}

	public void setDriverExpenses(Set<DriverExpense> driverExpenses) {
		this.driverExpenses = driverExpenses;
	}

	@Override
	public Driver toModel() {
		Driver driver = new Driver();
		driver.setId(id);
		driver.setName(name);
		driver.setPhone(phone);
		driver.setCars(cars);
		driver.setDriverExpenses(driverExpenses);
		return driver;
	}
}
