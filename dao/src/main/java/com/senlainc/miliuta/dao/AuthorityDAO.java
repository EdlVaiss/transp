package com.senlainc.miliuta.dao;

import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.api.IAuthorityDAO;
import com.senlainc.miliuta.model.creds.Authority;

@Repository
public class AuthorityDAO extends AbstractDAO<Authority> implements IAuthorityDAO {

	public AuthorityDAO() {
		super(Authority.class);
	}
}
