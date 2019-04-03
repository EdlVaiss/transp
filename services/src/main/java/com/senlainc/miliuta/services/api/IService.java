package com.senlainc.miliuta.services.api;

import java.util.List;

public interface IService<T> {
	boolean save(T item);

	List<T> getAll();
	
	T getById(Integer id);

	void update(T item);

	void deleteById(Integer id);

}
