package com.jspmvc;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jspmvc"})
public class EmployeeConfig {
	@Bean
   public EntityManager manager() {
	   return Persistence.createEntityManagerFactory("development").createEntityManager();
   }
}
