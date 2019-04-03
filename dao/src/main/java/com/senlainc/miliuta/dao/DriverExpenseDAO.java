package com.senlainc.miliuta.dao;


import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.IDriverExpenseDAO;
import com.senlainc.miliuta.model.DriverExpense;

@Repository
public class DriverExpenseDAO extends AbstractDAO<DriverExpense> implements IDriverExpenseDAO {
	public DriverExpenseDAO() {
		super(DriverExpense.class);
	}
}
