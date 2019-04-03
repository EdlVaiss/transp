package com.senlainc.miliuta.dao;


import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.ICarExpenseTypeDAO;
import com.senlainc.miliuta.model.CarExpenseType;

@Repository
public class CarExpenseTypeDAO extends AbstractDAO<CarExpenseType> implements ICarExpenseTypeDAO {
	public CarExpenseTypeDAO() {
		super(CarExpenseType.class);
	}
}
