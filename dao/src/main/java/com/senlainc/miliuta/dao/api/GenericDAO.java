package com.senlainc.miliuta.dao.api;

import java.util.List;

public interface GenericDAO<T> {
	void create(T item);

	List<T> readAll();
	
	T getById(Integer id);

	void update(T item);

	void delete(T item);
}
