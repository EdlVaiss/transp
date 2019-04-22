package com.senlainc.miliuta.dao.report.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

public class SelectionListFactory<K> {
	private Path<K> path;

	public SelectionListFactory(Path<K> root) {
		this.path = root;
	}

	public List<Selection<?>> getSelectionList(List<String> stringList) {
		ExpressionBuilder<K> eb = new ExpressionBuilder<>(path);

		List<Selection<?>> slectionList = stringList.stream().map(s -> eb.build(s)).collect(Collectors.toList());
		
		return slectionList;
	}

}
