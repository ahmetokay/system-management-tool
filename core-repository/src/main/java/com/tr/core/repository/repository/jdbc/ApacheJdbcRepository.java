package com.tr.core.repository.repository.jdbc;

import com.core.tr.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * JDBC ile veritabani islemlerinin jenerik olarak tanimlandigi siniftir.
 *
 * @author bocal
 */

class ApacheJdbcRepository<E extends BaseEntity> implements EntityJdbcRepository<E, Long> {

    private static final Logger logger = LoggerFactory.getLogger(ApacheJdbcRepository.class);

    private Class<E> genericClass;

    ApacheJdbcRepository(Class<E> genericClass) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E save(E entity) throws SQLException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E update(E entity) throws SQLException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) throws SQLException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(E entity) throws SQLException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteInDatabase(E entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteInDatabase(Long id) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E findById(Long aLong) throws SQLException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> query(String sql) throws SQLException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer count(String sql) {
        return null;
    }

    Class<E> getGenericClass() {
        return genericClass;
    }
}
