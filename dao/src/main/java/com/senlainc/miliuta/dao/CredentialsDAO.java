package com.senlainc.miliuta.dao;

import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.ICredentialsDAO;
import com.senlainc.miliuta.model.Credentials;

@Repository
public class CredentialsDAO extends AbstractDAO<Credentials> implements ICredentialsDAO {
	public CredentialsDAO() {
		super(Credentials.class);
	}
}
