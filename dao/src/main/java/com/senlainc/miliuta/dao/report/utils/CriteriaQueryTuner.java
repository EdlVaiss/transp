package com.senlainc.miliuta.dao.report.utils;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

public class CriteriaQueryTuner<T> implements ICriteriaQueryTuner<T> {
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Object[]> criteriaQuery;
	private Path<T> root;

	// TODO for test purposes, remove after use
	private final List<String> str = Arrays.asList("car.brand", "mileage");

	public CriteriaQueryTuner(CriteriaBuilder criteriaBuilder, Class<T> clazz) {
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
		List<Selection<?>> slectionList = slf.getSelectionList(str);
		criteriaQuery.multiselect(slectionList);
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneWhere() {
		// TODO Auto-generated method stub
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
