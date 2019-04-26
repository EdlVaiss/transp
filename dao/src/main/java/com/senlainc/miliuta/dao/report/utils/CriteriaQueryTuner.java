package com.senlainc.miliuta.dao.report.utils;

import java.util.ArrayList;
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
		List<String> selectPrefs = prefs.getSelectPrefs();
		if (selectPrefs == null) {
			return this;
		}
		SelectionListFactory<T> slf = new SelectionListFactory<>(root, criteriaBuilder);
		List<Selection<?>> slectionList = slf.getSelectionList(selectPrefs);
		criteriaQuery.multiselect(slectionList);
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneWhere() {
		List<WherePref> wherePrefs = prefs.getWherePrefs();
		if (wherePrefs == null) {
			wherePrefs = new ArrayList<>();
		}
		WherePredicateListFactory<T> wpaf = new WherePredicateListFactory<>(root, criteriaBuilder);
		List<Predicate> wherePredicates = wpaf.getWherePredicateList(wherePrefs);

		DatesPredicateBuilder<T> dpb = new DatesPredicateBuilder<>(root, criteriaBuilder);
		Predicate datesPredicate = dpb.getDatesPredicate(prefs.getLaterThanDate(), prefs.getEarlierThanDate());

		if (datesPredicate != null) {
			wherePredicates.add(datesPredicate);
		}

		criteriaQuery.where(wherePredicates.toArray(new Predicate[wherePredicates.size()]));
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneGroupBy() {
		Selection<?> selection = criteriaQuery.getSelection();
		if (selection == null) {
			return this;
		}
		if (selection.isCompoundSelection()) {
			criteriaQuery.groupBy((Expression<?>) selection.getCompoundSelectionItems().get(0));
		} else {
			criteriaQuery.groupBy((Expression<?>) selection);
		}
		return this;
	}

}
