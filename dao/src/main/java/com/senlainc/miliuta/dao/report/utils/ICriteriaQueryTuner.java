package com.senlainc.miliuta.dao.report.utils;

import javax.persistence.criteria.CriteriaQuery;

public interface ICriteriaQueryTuner<T> {
	CriteriaQueryTuner<T> tuneSelect();
	CriteriaQueryTuner<T> tuneWhere();
	CriteriaQueryTuner<T> tuneGroupBy();
	CriteriaQuery<Object[]> getCriteriaQuery();

}
