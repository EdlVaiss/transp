package com.senlainc.miliuta.dao.report.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

public class SelectionListFactory<K> {
	private Path<K> path;

	public SelectionListFactory(Path<K> root) {
		this.path = root;
	}

	public List<Selection<?>> getSelectionList(List<String> stringList) {
		List<Selection<?>> slectionList = new ArrayList<>();
		ExpressionBuilder<K> eb = new ExpressionBuilder<>(path);

		for (String string : stringList) {
			slectionList.add(eb.build(string));
		}

		return slectionList;
	}

}
