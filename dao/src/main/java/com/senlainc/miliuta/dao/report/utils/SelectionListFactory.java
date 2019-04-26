package com.senlainc.miliuta.dao.report.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

import com.senlainc.miliuta.model.AbstractExpense_;

public class SelectionListFactory<T> {
	private Path<T> root;
	private CriteriaBuilder criteriaBuilder;
	private static final String AGGREGATE_BY_ATTR = AbstractExpense_.COST;
	
	public SelectionListFactory(Path<T> root, CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}

	public List<Selection<?>> getSelectionList(List<String> stringList) {
		ExpressionBuilder<T> eb = new ExpressionBuilder<>(root);

		List<Selection<?>> slectionList = stringList.stream().map(s -> eb.build(s)).collect(Collectors.toList());
		slectionList.add(criteriaBuilder.sum(root.get(AGGREGATE_BY_ATTR)));
		return slectionList;

	}
}
