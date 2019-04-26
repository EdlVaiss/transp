package com.senlainc.miliuta.dao.report.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

public abstract class AbstractSelectionListFactory<T>implements ISelectionListFactory {
	protected Path<T> root;
	protected CriteriaBuilder criteriaBuilder;

	protected AbstractSelectionListFactory(Path<T> root, CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}
	
@Override
	public List<Selection<?>> getSelectionList(List<String> stringList) {
		ExpressionBuilder<T> eb = new ExpressionBuilder<>(root);

		List<Selection<?>> slectionList = stringList.stream().map(s -> eb.build(s)).collect(Collectors.toList());
		return slectionList;
	}
}
