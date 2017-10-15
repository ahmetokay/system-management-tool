package com.tr.core.repository.repository.jdbc;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * @author bocal
 */

public interface EntityJdbcRepository<E, ID extends Serializable> {

    E save(E entity) throws SQLException;

    E update(E entity) throws SQLException;

    void delete(Long id) throws SQLException;

    void delete(E entity) throws SQLException;

    void deleteInDatabase(E entity);

    void deleteInDatabase(Long id);

    E findById(ID id) throws SQLException;

    List<E> query(String sql) throws SQLException;

    Integer count(String sql);

}
