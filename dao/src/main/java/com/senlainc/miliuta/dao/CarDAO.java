package com.senlainc.miliuta.dao;


import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.ICarDAO;
import com.senlainc.miliuta.model.Car;

@Repository
public class CarDAO extends AbstractDAO<Car> implements ICarDAO {
	public CarDAO() {
		super(Car.class);
	}
}
