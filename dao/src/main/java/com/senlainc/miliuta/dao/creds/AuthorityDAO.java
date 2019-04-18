package com.senlainc.miliuta.dao.creds;

import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.AbstractDAO;
import com.senlainc.miliuta.dao.api.creds.IAuthorityDAO;
import com.senlainc.miliuta.model.creds.Authority;

@Repository
public class AuthorityDAO extends AbstractDAO<Authority> implements IAuthorityDAO {

	public AuthorityDAO() {
		super(Authority.class);
	}
}
