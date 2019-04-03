package com.senlainc.miliuta.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cars", catalog = "auto")
public class Car implements Serializable {

	private static final long serialVersionUID = 6750136446786615444L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "reg_number", unique = true, nullable = false, length = 10)
	private String registrationNumber;

	@Column(name = "brand", nullable = false, length = 20)
	private String brand;

	@Column(name = "model", nullable = false, length = 20)
	private String model;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private Set<CarExpense> carExpenses = new HashSet<>(0);

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "cars")
	private Set<Driver> drivers = new HashSet<>(0);

	public Car() {
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

	public Set<CarExpense> getCarExpenses() {
		return this.carExpenses;
	}

	public void setCarExpenses(Set<CarExpense> carExpenses) {
		this.carExpenses = carExpenses;
	}

	public Set<Driver> getDrivers() {
		return this.drivers;
	}

	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}
}
