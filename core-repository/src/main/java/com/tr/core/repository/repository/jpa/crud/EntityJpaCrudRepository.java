package com.tr.core.repository.repository.jpa.crud;

import com.core.tr.entity.EntityRule;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


/**
 * @param <E>
 * @author bocal
 */

@NoRepositoryBean
public interface EntityJpaCrudRepository<E extends EntityRule> extends CrudRepository<E, Long> {

    /**
     * {@inheritDoc}
     */
    @Override
    @Query("select e from #{#entityName} e where e.isactive = false")
    List<E> findAll();

    /**
     * {@inheritDoc}
     */
    @Override
    @Query("select e from #{#entityName} e where e.pkid in ?1 and e.isactive = false")
    Iterable<E> findAll(Iterable<Long> ids);

    /**
     * {@inheritDoc}
     */
    @Override
    @Query("select e from #{#entityName} e where e.pkid = ?1 and e.isactive = false")
    E findOne(Long pkid);

    /**
     * {@inheritDoc}
     */
    @Query("select e from #{#entityName} e where e.isactive = true")
    List<E> findDeleted();

    /**
     * {@inheritDoc}
     */
    @Override
    @Query("select count(e) from #{#entityName} e where e.isactive = false")
    long count();

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean exists(Long id) {
        return findOne(id) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Query("update #{#entityName} e set e.isactive = true where e.pkid = ?1")
    @Modifying
    void delete(Long id);

    /**
     * {@inheritDoc}
     */
    @Override
    default void delete(E entity) {
        delete(entity.getPkid());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void delete(Iterable<? extends E> entities) {
        entities.forEach(entity -> delete(entity.getPkid()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Query("update #{#entityName} e set e.isactive = true")
    @Modifying
    void deleteAll();

}
