package com.senlainc.miliuta.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "drivers", catalog = "auto")
public class Driver implements Serializable {

	private static final long serialVersionUID = 142757556876611901L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "phone", nullable = true, length = 20)
	private String phone;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "cars_drivers", catalog = "auto", joinColumns = {
			@JoinColumn(name = "drivers_id") }, inverseJoinColumns = { @JoinColumn(name = "cars_id") })
	private Set<Car> cars = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
	private Set<DriverExpense> driverExpenses = new HashSet<>(0);

	public Driver() {
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
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Set<DriverExpense> getDriverExpenses() {
		return this.driverExpenses;
	}

	public void setDriverExpenses(Set<DriverExpense> driverExpenses) {
		this.driverExpenses = driverExpenses;
	}
}
