package com.senlainc.miliuta.dao.report.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import com.senlainc.miliuta.model.report.WherePref;

public class WherePredicateArrayFactory<T> {
	private Path<T> root;
	private CriteriaBuilder criteriaBuilder;

	public WherePredicateArrayFactory(Path<T> root, CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}

	public Predicate[] getWherePredicateArray(List<WherePref> wherePrefs) {
		WherePredicateBuilder<T> predicateBuilder = new WherePredicateBuilder<>(root, criteriaBuilder);

		Predicate[] wherePredicates = wherePrefs.stream().map(pred -> predicateBuilder.build(pred))
				.toArray(size -> new Predicate[size]);
		return wherePredicates;
	}
}
