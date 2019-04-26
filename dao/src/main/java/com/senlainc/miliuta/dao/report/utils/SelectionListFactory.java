package com.senlainc.miliuta.dao.report.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

import com.senlainc.miliuta.model.CarExpense_;

public class SelectionListFactory<T> extends AbstractSelectionListFactory<T> {
	
	public SelectionListFactory(Path<T> root, CriteriaBuilder criteriaBuilder) {
		super(root, criteriaBuilder);
	}

	@Override
	public List<Selection<?>> getSelectionList(List<String> stringList) {
		List<Selection<?>> slectionList = super.getSelectionList(stringList);
		slectionList.add(criteriaBuilder.sum(root.get(CarExpense_.COST)));
		return slectionList;

	}
}
