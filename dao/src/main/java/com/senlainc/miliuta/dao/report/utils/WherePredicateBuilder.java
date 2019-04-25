package com.senlainc.miliuta.dao.report.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import com.senlainc.miliuta.model.report.WherePref;
import com.senlainc.miliuta.model.report.valueholders.ValueHolderFactory;

public class WherePredicateBuilder<T> {
	private Path<T> root;
	private CriteriaBuilder criteriaBuilder;

	public WherePredicateBuilder(Path<T> root, CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}

	private Expression<T> getPath(String stringPath) {
		ExpressionBuilder<T> eb = new ExpressionBuilder<>(root);
		Expression<T> path = eb.build(stringPath);
		return path;
	}
	
	public Predicate build(WherePref pref) {
		Expression<T> path = getPath(pref.getPath());
		ValueHolderFactory vhf = new ValueHolderFactory(pref.getParam());
		
		switch (pref.getOperator()) {
		case eq:
			return criteriaBuilder.equal(path, vhf.getValueHolder().getValue());
		case lt:
			return criteriaBuilder.lt((Expression<Number>)path, (Number)(vhf.getValueHolder().getValue()));
		case gt:
			return criteriaBuilder.gt((Expression<Number>)path, (Number)(vhf.getValueHolder().getValue()));
		default:
			throw new UnsupportedOperationException();
		}
	}
}
