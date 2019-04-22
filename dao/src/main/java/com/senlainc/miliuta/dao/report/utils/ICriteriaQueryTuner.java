package com.senlainc.miliuta.dao.report.utils;

import javax.persistence.criteria.CriteriaQuery;

public interface ICriteriaQueryTuner<K> {
	CriteriaQueryTuner<K> tuneSelect();
	CriteriaQueryTuner<K> tuneWhere();
	CriteriaQueryTuner<K> tuneGroupBy();
	CriteriaQuery<Object[]> getCriteriaQuery();

}
