package com.scc.app.dao;

import static java.lang.Class.forName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDAO<T> {

    public AbstractDAO() {}

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional(readOnly = true)
    public T findById(final Long id) {
        return entityManager.find(getModelClass(), id);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true)
    public List<T> findAll() {
        final CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(getModelClass()));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    public long count() {
        return ((Number) entityManager.createQuery("select count(o) from " + getModelClass().getName() + " o").getSingleResult()).longValue();
    }

    @Transactional
    public void persist(final T c) {
        entityManager.persist(c);
    }

    @Transactional
    public void merge(final T c) {
        entityManager.merge(c);
    }

    @Transactional
    public void remove(final Long id) {
        remove(findById(id));
    }

    @Transactional
    public void remove(final T c) {
        entityManager.remove(c);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Transactional(readOnly = true)
    public List<T> findByAttributes(final Map<String, Object> attributes) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getModelClass());
        final Root<T> root = criteriaQuery.from(getModelClass());

        final List<Predicate> predicates = new ArrayList<Predicate>();
        for (final Entry<String, Object> entry : attributes.entrySet()) {
            if (root.get(entry.getKey()) != null) {
                predicates.add(criteriaBuilder.like((Expression) root.get(entry.getKey()), "%" + entry.getValue() + "%"));
            }
        }
        criteriaQuery.where(predicates.toArray(new Predicate[] {}));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    public List<T> findByAttribute(final String field, final Object value) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getModelClass());
        final Root<T> root = criteriaQuery.from(getModelClass());

        final List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.get(field), value));
        criteriaQuery.where(predicates.toArray(new Predicate[] {}));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    public T findOneByAttribute(final String field, final Object value) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getModelClass());
        final Root<T> root = criteriaQuery.from(getModelClass());

        final List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.get(field), value));
        criteriaQuery.where(predicates.toArray(new Predicate[] {}));
        try {
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (final NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getModelClass() {
        try {
            return (Class<T>) forName(getClass().getName().replace("dao", "entity").replace("DAOImpl", ""));
        } catch (final ClassNotFoundException e) {
            throw new RuntimeException("Entity and DAO classes should follow the naming convention.");
        }
    }
}
