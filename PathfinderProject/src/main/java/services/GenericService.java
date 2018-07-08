package services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public abstract class GenericService<T extends Serializable> {

	private Class<T> clazz;
	protected EntityManager em;

	public GenericService(Class<T> clazz) {
		this.clazz = clazz;
	}

	public GenericService(Class<T> clazz, EntityManager entityManager) {
		this.clazz = clazz;
		this.em = entityManager;
	}

	public EntityManager getEm() {
		return this.em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public T create(T entity) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();
		em.refresh(entity);
		return entity;
	}

	public T update(T entity) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(entity);
		et.commit();
		em.refresh(entity);
		return entity;
	}

	public void remove(T entity) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();
	}

	public void rollback(T entity) {
		EntityTransaction et = em.getTransaction();
		et.rollback();
	}

	public T findOne(int primaryKey) {
		return em.find(clazz, primaryKey);
	}

	public T findOneByName(String name) {

		TypedQuery<T> query = em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t WHERE t.name LIKE :name",
				clazz);
		query.setParameter("name", name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void deleteById(int primaryKey) {
		T entity = findOne(primaryKey);
		remove(entity);
	}

	public List<T> findAll() {
		TypedQuery<T> query = em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz);
		return query.getResultList();
	}
}
