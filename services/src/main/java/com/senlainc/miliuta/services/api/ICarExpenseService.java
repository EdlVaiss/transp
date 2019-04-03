package com.senlainc.miliuta.services.api;

import java.util.List;

public interface ICarExpenseService<T> extends IService<T> {
	List<Object[]> readAllExt();
}
