package com.tr.core.repository.repository.jpa.factory;

import com.core.tr.entity.BaseEntity;
import com.tr.core.repository.repository.jpa.EntityJpaRepositoryImpl;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * @param <T>
 * @author bocal
 */
public class EntityJpaRepositoryFactory<T extends BaseEntity> extends JpaRepositoryFactory {

    private final EntityManager entityManager;

    public EntityJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object getTargetRepository(RepositoryInformation information) {
        return new EntityJpaRepositoryImpl<>((Class<T>) information.getDomainType(), entityManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return EntityJpaRepositoryImpl.class;
    }
}