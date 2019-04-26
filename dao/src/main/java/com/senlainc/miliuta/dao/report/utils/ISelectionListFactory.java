package com.senlainc.miliuta.dao.report.utils;

import java.util.List;

import javax.persistence.criteria.Selection;

public interface ISelectionListFactory {
	List<Selection<?>> getSelectionList(List<String> stringList);
}
