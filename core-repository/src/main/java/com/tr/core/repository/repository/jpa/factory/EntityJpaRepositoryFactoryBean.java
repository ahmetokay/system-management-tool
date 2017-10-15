package com.tr.core.repository.repository.jpa.factory;

import com.core.tr.entity.BaseEntity;
import com.tr.core.repository.repository.jpa.EntityJpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * @param <ER>
 * @param <E>
 * @author bocal
 */
public class EntityJpaRepositoryFactoryBean<ER extends EntityJpaRepository<E>, E extends BaseEntity> extends JpaRepositoryFactoryBean<ER, E, Long> {

    public EntityJpaRepositoryFactoryBean(Class<? extends ER> repositoryInterface) {
        super(repositoryInterface);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new EntityJpaRepositoryFactory<>(entityManager);
    }

}