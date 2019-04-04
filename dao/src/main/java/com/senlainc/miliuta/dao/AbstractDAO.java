package com.senlainc.miliuta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.senlainc.miliuta.dao.api.GenericDAO;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> clazz;

	public AbstractDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void create(T item) {
		entityManager.persist(item);
	}

	@Override
	public List<T> readAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		Root<T> root = criteriaQuery.from(clazz);
		criteriaQuery.select(root);
		List<T> itemsList = entityManager.createQuery(criteriaQuery).getResultList();
		return itemsList;
	}

	@Override
	public void update(T item) {
		entityManager.merge(item);
	}

	@Override
	public void delete(T item) {
		entityManager.remove(item);
	}

	@Override
	public T getById(Integer id) {
		return entityManager.find(clazz, id);
	}

}
