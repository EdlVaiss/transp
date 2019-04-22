package com.senlainc.miliuta.dao.report.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

public class SelectionListFactory<K> {
	private Path<K> root;
	private CriteriaBuilder criteriaBuilder;
	private final String AGGREGATE_FIELD = "cost";

	public SelectionListFactory(final Path<K> root, final CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}

	public List<Selection<?>> getSelectionList(List<String> stringList) {
		ExpressionBuilder<K> eb = new ExpressionBuilder<>(root);

		List<Selection<?>> slectionList = stringList.stream().map(s -> eb.build(s)).collect(Collectors.toList());
		slectionList.add(criteriaBuilder.sum(root.get(AGGREGATE_FIELD)));
		return slectionList;
	}

}
