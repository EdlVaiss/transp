package com.senlainc.miliuta.dao;


import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.IDriverDAO;
import com.senlainc.miliuta.model.Driver;

@Repository
public class DriverDAO extends AbstractDAO<Driver> implements IDriverDAO {
	public DriverDAO() {
		super(Driver.class);
	}
}
