package com.tr.core.repository.configuration;

import com.tr.core.repository.repository.jpa.factory.EntityJpaRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author bocal
 */

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(repositoryFactoryBeanClass = EntityJpaRepositoryFactoryBean.class)
public class RepositoryConfiguration {

}
