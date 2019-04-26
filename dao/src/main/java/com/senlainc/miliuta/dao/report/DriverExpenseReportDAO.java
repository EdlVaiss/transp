package com.senlainc.miliuta.dao.report;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.report.utils.CriteriaQueryTuner;
import com.senlainc.miliuta.dao.report.utils.ICriteriaQueryTuner;
import com.senlainc.miliuta.model.DriverExpense;
import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;

@Repository
public class DriverExpenseReportDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Object[]> getReport(ReportPrefsTransferObject prefs) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		ICriteriaQueryTuner<DriverExpense> CQTuner = new CriteriaQueryTuner<>(prefs, criteriaBuilder, DriverExpense.class);
		
		CriteriaQuery<Object[]> criteriaQuery = CQTuner
				.tuneSelect()
				.tuneWhere()
				.tuneGroupBy()
				.getCriteriaQuery();
		
		List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}
}
