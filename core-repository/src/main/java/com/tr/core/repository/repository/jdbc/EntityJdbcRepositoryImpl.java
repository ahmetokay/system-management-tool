package com.tr.core.repository.repository.jdbc;


import com.core.tr.entity.BaseEntity;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

/**
 * Gelistiriciye acilmis {@link ApacheJdbcRepository} sinifini kullanan temel veritabani fonksiyonlarini sunan jeenrik siniftir.
 *
 * @author bocal
 */

public abstract class EntityJdbcRepositoryImpl<E extends BaseEntity> implements EntityJdbcRepository<E, Long> {

    private ApacheJdbcRepository<E> apacheJdbc;

    public EntityJdbcRepositoryImpl() {
        Class<E> genericClass = (Class<E>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        this.apacheJdbc = new ApacheJdbcRepository<>(genericClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E save(E entity) throws SQLException {
        return apacheJdbc.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E update(E entity) throws SQLException {
        return apacheJdbc.update(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) throws SQLException {
        apacheJdbc.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(E entity) throws SQLException {
        delete(entity.getPkid());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E findById(Long aLong) throws SQLException {
        return apacheJdbc.findById(aLong);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> query(String sql) throws SQLException {
        return apacheJdbc.query(sql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer count(String sql) {
        return apacheJdbc.count(sql);
    }
}