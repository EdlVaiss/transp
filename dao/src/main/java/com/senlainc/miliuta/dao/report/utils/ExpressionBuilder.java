package com.senlainc.miliuta.dao.report.utils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;

public class ExpressionBuilder<K> {
	private Path<K> root;

	public ExpressionBuilder(Path<K> root) {
		this.root = root;
	}

	public Expression<K> build(String stringPath) {
		String[] pathArr = stringPath.split("\\.");
		Path<K> path = null;
		
		for (int i = 1; i < pathArr.length; i++) {
			if (i == 1) {
				path = root.get(pathArr[i]);
			} else {
				path = path.get(pathArr[i]);
			}
		}
		return path;
	}
}
