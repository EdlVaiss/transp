package com.senlainc.miliuta.dao.api;

import java.util.List;

import com.senlainc.miliuta.model.CarExpense;

public interface ICarExpenseDAO extends GenericDAO<CarExpense> {
	List<Object[]> readAllExt();
}
