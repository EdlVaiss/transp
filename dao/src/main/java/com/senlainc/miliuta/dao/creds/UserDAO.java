package com.senlainc.miliuta.dao.creds;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senlainc.miliuta.dao.AbstractDAO;
import com.senlainc.miliuta.dao.api.creds.IUserDAO;
import com.senlainc.miliuta.model.creds.User;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	public UserDAO() {
		super(User.class);
	}

	@Override
	public User getByName(String name) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> userRoot = criteriaQuery.from(User.class);
		criteriaQuery.select(userRoot).where(criteriaBuilder.equal(userRoot.get("userName"), name));
		User user = entityManager.createQuery(criteriaQuery).getSingleResult();
		return user;
	}
}
