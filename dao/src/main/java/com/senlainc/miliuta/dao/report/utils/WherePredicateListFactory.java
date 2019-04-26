package com.senlainc.miliuta.dao.report.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import com.senlainc.miliuta.model.report.WherePref;

public class WherePredicateListFactory<T> {
	private Path<T> root;
	private CriteriaBuilder criteriaBuilder;

	public WherePredicateListFactory(Path<T> root, CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}

	public List<Predicate> getWherePredicateList(List<WherePref> wherePrefs) {
		WherePredicateBuilder<T> predicateBuilder = new WherePredicateBuilder<>(root, criteriaBuilder);

		List<Predicate> wherePredicates = wherePrefs.stream().map(pred -> predicateBuilder.build(pred))
				.collect(Collectors.toList());
		return wherePredicates;
	}
}
