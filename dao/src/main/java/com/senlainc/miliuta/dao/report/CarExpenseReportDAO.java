package com.senlainc.miliuta.dao.report;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.report.utils.CriteriaQueryTuner;
import com.senlainc.miliuta.dao.report.utils.ICriteriaQueryTuner;
import com.senlainc.miliuta.model.CarExpense;
import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;

@Repository
public class CarExpenseReportDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Object[]> getReport(ReportPrefsTransferObject prefs) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		ICriteriaQueryTuner<CarExpense> CQTuner = new CriteriaQueryTuner<>(prefs, criteriaBuilder, CarExpense.class);
		
		CriteriaQuery<Object[]> criteriaQuery = CQTuner
				.tuneSelect()
				.tuneWhere()
				.tuneGroupBy()
				.getCriteriaQuery();
		
		List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}
}
