package com.senlainc.miliuta.dao.report.utils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import com.senlainc.miliuta.model.report.WherePref;

public class WherePredicateBuilder<T> {
	private Path<T> root;

	public WherePredicateBuilder(Path<T> root) {
		this.root = root;
	}
	
	public Predicate build(WherePref pref) {
		ExpressionBuilder<T> eb = new ExpressionBuilder<>(root);
		Expression<T> path = eb.build(pref.getPath());
		
		return null;
	}
}
