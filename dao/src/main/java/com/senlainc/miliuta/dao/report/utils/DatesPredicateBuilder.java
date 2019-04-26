package com.senlainc.miliuta.dao.report.utils;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import com.senlainc.miliuta.model.AbstractExpense_;

public class DatesPredicateBuilder<T> {
	private Path<T> root;
	private CriteriaBuilder criteriaBuilder;
	private static final String  DATE_ATTR = AbstractExpense_.DATE;

	public DatesPredicateBuilder(Path<T> root, CriteriaBuilder criteriaBuilder) {
		this.root = root;
		this.criteriaBuilder = criteriaBuilder;
	}

	public Predicate getDatesPredicate(LocalDate laterThanDate, LocalDate earlierThanDate) {

		if (laterThanDate == null && earlierThanDate == null) {
			return null;
		}
		if (laterThanDate == null) {
			return criteriaBuilder.lessThanOrEqualTo(root.get(DATE_ATTR), earlierThanDate);
		} else if (earlierThanDate == null) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get(DATE_ATTR), laterThanDate);
		} else {

			if (laterThanDate.isAfter(earlierThanDate)) {
				LocalDate buff = earlierThanDate;
				earlierThanDate = laterThanDate;
				laterThanDate = buff;
			}
			
			return criteriaBuilder.between(root.get(DATE_ATTR), laterThanDate, earlierThanDate);
		}
	}
}
