package com.senlainc.miliuta.dao.api;

import com.senlainc.miliuta.model.creds.User;

public interface IUserDAO extends GenericDAO<User> {
	User getByName(String name);
}
