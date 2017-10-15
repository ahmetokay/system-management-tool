package com.tr.core.repository.repository.jpa;

import com.core.tr.entity.BaseEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @param <E>
 * @author bocal
 */

public class EntityJpaRepositoryImpl<E extends BaseEntity> extends SimpleJpaRepository<E, Long> implements EntityJpaRepository<E> {

    private final Class<E> domainClass;

    private final EntityManager em;

    public EntityJpaRepositoryImpl(Class<E> domainClass, EntityManager em) {
        super(domainClass, em);
        this.domainClass = domainClass;
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> query(String sql) {
        return em.createQuery(sql).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer count(String sql) {
        Query query = em.createQuery(sql);
        Long singleResult = (Long) query.getSingleResult();
        return singleResult.intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteInDatabase(E entity) {
        em.remove(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteInDatabase(Long id) {
        E entity = findOne(id);
        deleteInDatabase(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long aLong) {
        E entity = findOne(aLong);
        delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(E entity) {
        entity.setIsActive(false);
        em.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Iterable<? extends E> entities) {
        for (E entity : entities) {
            delete(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteInBatch(Iterable<E> entities) {
        for (E entity : entities) {
            delete(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAll() {
        List<E> resultList = findAll();
        if (resultList != null) {
            this.delete(resultList);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllInBatch() {
        deleteAll();
    }

    @Override
    public E findById(Long aLong) {
        return findOne(aLong);
    }
}
