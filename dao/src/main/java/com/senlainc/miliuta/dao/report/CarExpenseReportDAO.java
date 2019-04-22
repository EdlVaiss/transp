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

import com.senlainc.miliuta.dao.report.utils.CriteriaQueryTuner;
import com.senlainc.miliuta.dao.report.utils.ExpressionBuilder;
import com.senlainc.miliuta.dao.report.utils.ICriteriaQueryTuner;
import com.senlainc.miliuta.dao.report.utils.SelectionListFactory;
import com.senlainc.miliuta.model.CarExpense;

@Repository
public class CarExpenseReportDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Object[]> getReport() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		ICriteriaQueryTuner<CarExpense> CQTuner = new CriteriaQueryTuner<>(criteriaBuilder, CarExpense.class);
		
		CriteriaQuery<Object[]> criteriaQuery = CQTuner
				.tuneSelect()
				.tuneGroupBy()
				.getCriteriaQuery();

		List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}
}
