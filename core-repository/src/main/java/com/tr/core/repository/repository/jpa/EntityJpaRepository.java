package com.tr.core.repository.repository.jpa;

import com.core.tr.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @param <E>
 * @author bocal
 */
@NoRepositoryBean
public interface EntityJpaRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

    <S extends E> S save(S entity);

    E findById(Long id);

    void deleteInDatabase(E entity);

    void deleteInDatabase(Long id);

    List<E> query(String sql);

    Integer count(String sql);

    EntityManager getEntityManager();

}
