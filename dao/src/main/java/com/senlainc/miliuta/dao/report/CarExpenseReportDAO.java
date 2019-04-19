package com.senlainc.miliuta.dao.report;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.ParameterRegistry;
import org.hibernate.query.criteria.internal.compile.RenderingContext;
import org.hibernate.query.criteria.internal.expression.ExpressionImpl;
import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.report.utils.ExpressionBuilder;
import com.senlainc.miliuta.dao.report.utils.SelectionListFactory;
import com.senlainc.miliuta.model.CarExpense;

@Repository
public class CarExpenseReportDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Object[]> getReport(List<String> str) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

		Root<CarExpense> carExpense = criteriaQuery.from(CarExpense.class);
		
		SelectionListFactory<CarExpense> slf = new SelectionListFactory<>(carExpense);
		
		criteriaQuery.multiselect(slf.getSelectionList(str));

		//criteriaQuery.where(restrictions);

		List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}
}
