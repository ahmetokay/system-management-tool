package com.core.tr.configuration.configuration;

import com.core.tr.configuration.registration.CoreListenerRegistration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author bocal
 */

@Configuration
@EnableAspectJAutoProxy
public class CoreSystemConfiguration {

  @Bean
  public ServletListenerRegistrationBean<CoreListenerRegistration> loaderContextListener() {
    return new ServletListenerRegistrationBean<>(new CoreListenerRegistration());
  }

}
