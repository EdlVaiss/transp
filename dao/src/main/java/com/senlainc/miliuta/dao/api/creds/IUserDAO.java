package com.senlainc.miliuta.dao.api.creds;

import com.senlainc.miliuta.dao.api.GenericDAO;
import com.senlainc.miliuta.model.creds.User;

public interface IUserDAO extends GenericDAO<User> {
	User getByName(String name);
}
