package com.smt;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author bocal
 */

@SpringBootApplication
public class SmtServerApplication {

  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(SmtServerApplication.class,
        SmtServerConfiguration.class);
    ConfigurableApplicationContext run = builder.build().run(args);
    System.out.println("\u001B[32mSystem Management Server started.\u001B[32m");
  }

}
