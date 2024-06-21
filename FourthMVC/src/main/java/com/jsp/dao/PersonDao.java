package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Person;

@Repository
public class PersonDao {
    @Autowired
	private EntityManager manager;
    
    public Person savePerson(Person person) {
    	EntityTransaction transaction = manager.getTransaction();
    	transaction.begin();
    	manager.persist(person);
    	transaction.commit();
    	return person;
    }
    
    public Person updatePerson(Person person) {
    	Person dbp = manager.find(Person.class, person.getId());
    	if(dbp!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		dbp.setAge(person.getAge());
    		dbp.setEmail(person.getEmail());
    		dbp.setName(person.getName());
    		dbp.setPassword(person.getPassword());
    		dbp.setSalary(person.getSalary());
    		transaction.begin();
    		transaction.commit();
    		return dbp;
    		
    		}return null;
    }
    
    public Person findbyid(int id) {
    	return manager.find(Person.class, id);
    }
    
    public Person deleper(int id) {
    	Person dbr = manager.find(Person.class, id);
    	if(dbr!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		transaction.begin();
    		manager.remove(dbr);
    		transaction.commit();
    		return dbr;
    	}return null;
    }
}
