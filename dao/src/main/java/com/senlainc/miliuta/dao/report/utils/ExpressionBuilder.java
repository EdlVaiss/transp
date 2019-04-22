package com.senlainc.miliuta.dao.report.utils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;

public class ExpressionBuilder<T> {
	private Path<T> root;

	public ExpressionBuilder(Path<T> root) {
		this.root = root;
	}

	public Expression<T> build(String stringPath) {
		String[] pathArr = stringPath.split("\\.");
		Path<T> path = null;
		
		for (int i = 0; i < pathArr.length; i++) {
			if (i == 0) {
				path = root.get(pathArr[i]);
			} else {
				path = path.get(pathArr[i]);
			}
		}
		return path;
	}
}
