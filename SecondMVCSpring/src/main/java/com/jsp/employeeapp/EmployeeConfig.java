package com.jsp.employeeapp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jsp.employeeapp"})
public class EmployeeConfig {
	@Bean
   public EntityManager entityManager() {
	   return Persistence.createEntityManagerFactory("development").createEntityManager();
   }
}
