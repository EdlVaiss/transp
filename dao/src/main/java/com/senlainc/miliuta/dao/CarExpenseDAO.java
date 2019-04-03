package com.senlainc.miliuta.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.ICarExpenseDAO;
import com.senlainc.miliuta.model.CarExpense;
import com.senlainc.miliuta.model.CarExpenseType_;
import com.senlainc.miliuta.model.CarExpense_;
import com.senlainc.miliuta.model.Car_;

@Repository
public class CarExpenseDAO extends AbstractDAO<CarExpense> implements ICarExpenseDAO {
	
	public CarExpenseDAO() {
		super(CarExpense.class);
	}

	@Override
	public List<Object[]> readAllExt() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
		Root<CarExpense> carExpense = q.from(CarExpense.class);
		Path<String> regNumber = carExpense.get(CarExpense_.car).get(Car_.registrationNumber);
		Path<String> expenseType = carExpense.get(CarExpense_.expenseType).get(CarExpenseType_.expenseType);
		q.multiselect(carExpense, regNumber, expenseType);
		List<Object[]> carExpenses = entityManager.createQuery(q).getResultList();
		return carExpenses;
	}
}
