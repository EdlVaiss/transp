package com.senlainc.miliuta.dao.report.utils;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;


public class CriteriaQueryTuner<T> implements ICriteriaQueryTuner<T>{
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Object[]> criteriaQuery;
	private Path<T> root;

	//TODO for test purposes? remove after use 
	private final List<String> str = Arrays.asList("car.brand","mileage");
	
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
		criteriaQuery.multiselect(slf.getSelectionList(str));
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneWhere() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public CriteriaQueryTuner<T> tuneGroupBy() {
		criteriaQuery.groupBy(root.get("car").get("brand"));
		return this;
	}
	
	
}
