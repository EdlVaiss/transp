package com.senlainc.miliuta.services;


import org.springframework.beans.factory.annotation.Autowired;

import com.senlainc.miliuta.dao.api.*;

public abstract class AbstractService {
	@Autowired
	protected ICredentialsDAO credentialsDAO;
	
	@Autowired
	protected ICarDAO carDAO;
	@Autowired
	protected ICarExpenseDAO carExpenseDAO;
	@Autowired
	protected ICarExpenseTypeDAO carExpenseTypeDAO;
	
	@Autowired
	protected IDriverDAO driverDAO;
	@Autowired
	protected IDriverExpenseDAO driverExpenseDAO;
	@Autowired
	protected IDriverExpenseTypeDAO driverExpenseTypeDAO;
}
