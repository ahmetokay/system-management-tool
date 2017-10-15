package com.smt;

import com.core.tr.entity.BaseEntity;
import com.tr.core.repository.configuration.RepositoryConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author bocal
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
@EntityScan(basePackages = {"com"}, basePackageClasses = {BaseEntity.class})
public class SmtServerConfiguration extends RepositoryConfiguration {


}