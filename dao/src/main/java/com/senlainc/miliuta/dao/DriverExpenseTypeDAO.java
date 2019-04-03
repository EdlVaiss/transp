package com.senlainc.miliuta.dao;


import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.IDriverExpenseTypeDAO;
import com.senlainc.miliuta.model.DriverExpenseType;

@Repository
public class DriverExpenseTypeDAO extends AbstractDAO<DriverExpenseType> implements IDriverExpenseTypeDAO {
	public DriverExpenseTypeDAO() {
		super(DriverExpenseType.class);
	}
}
