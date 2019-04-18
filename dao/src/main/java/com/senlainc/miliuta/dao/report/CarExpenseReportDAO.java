package com.senlainc.miliuta.dao.report;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.senlainc.miliuta.model.CarExpense;

public class CarExpenseReportDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Object[]> getReport(List<Selection<?>> selectionList, Predicate[] restrictions) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

		Root<CarExpense> carExpense = criteriaQuery.from(CarExpense.class);
		criteriaQuery.multiselect(selectionList);
		
		criteriaQuery.where(restrictions);
		
		List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}
}
