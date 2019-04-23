package com.senlainc.miliuta.dao.report.utils;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Selection;

import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;
import com.senlainc.miliuta.model.report.WherePref;

public class CriteriaQueryTuner<T> implements ICriteriaQueryTuner<T> {
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Object[]> criteriaQuery;
	private Path<T> root;
	private ReportPrefsTransferObject prefs;

	public CriteriaQueryTuner(ReportPrefsTransferObject prefs, CriteriaBuilder criteriaBuilder, Class<T> clazz) {
		this.prefs = prefs;
		this.criteriaBuilder = criteriaBuilder;
		criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		root = criteriaQuery.from(clazz);
	}

	@Override
	public CriteriaQuery<Object[]> getCriteriaQuery() {
		return criteriaQuery;
	}

	@Override
	public CriteriaQueryTuner<T> tuneSelect() {
		SelectionListFactory<T> slf = new SelectionListFactory<>(root, criteriaBuilder);
		List<Selection<?>> slectionList = slf.getSelectionList(prefs.getSelectPrefs());
		criteriaQuery.multiselect(slectionList);
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneWhere() {
		List<WherePref> wherePrefs = prefs.getWherePrefs();
		if (wherePrefs.size() == 0) {
			return this;
		}
		WherePredicateBuilder<T> predicateBuilder = new WherePredicateBuilder<>(root);

		Predicate[] wherePredicates = wherePrefs.stream().map(pred -> predicateBuilder.build(pred))
				.toArray(size -> new Predicate[size]);
		criteriaQuery.where(wherePredicates);
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneGroupBy() {
		Selection<?> selection = criteriaQuery.getSelection();
		if (selection.isCompoundSelection()) {
			criteriaQuery.groupBy((Expression<?>) selection.getCompoundSelectionItems().get(0));
		} else {
			criteriaQuery.groupBy((Expression<?>) selection);
		}
		return this;
	}

}
