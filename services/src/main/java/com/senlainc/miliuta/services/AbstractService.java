package com.senlainc.miliuta.services;


import org.springframework.beans.factory.annotation.Autowired;

import com.senlainc.miliuta.dao.api.*;
import com.senlainc.miliuta.dao.api.creds.IAuthorityDAO;
import com.senlainc.miliuta.dao.api.creds.IUserDAO;

public abstract class AbstractService {
	@Autowired
	protected ICredentialsDAO credentialsDAO;
	@Autowired
	protected IUserDAO userDAO;
	@Autowired
	protected IAuthorityDAO authorityDAO;
	
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
