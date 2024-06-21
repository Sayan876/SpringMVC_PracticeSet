package com.jspmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspmvc.dto.Employee;

@Repository
public class EmployeeDao {
    @Autowired
	private EntityManager manager;
    
    public Employee saveEmployee(Employee employee) {
    	EntityTransaction transaction = manager.getTransaction();
    	transaction.begin();
    	manager.persist(employee);
    	transaction.commit();
    	return employee;
    }
    
    public Employee updateEmployee(Employee employee) {
    	Employee dbemp = manager.find(Employee.class, employee.getId());
    	if(dbemp!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		dbemp.setDesg(employee.getDesg());
    		dbemp.setName(employee.getName());
    		transaction.begin();
    		transaction.commit();
    		return dbemp;
    	}else {
    		return null;
    	}
    }
    
    public Employee findById(int id) {
    	return manager.find(Employee.class, id);
    }
    
    public Employee verify(int id, String name) {
    	Query query = manager.createQuery("select e from Employee e where e.id=?1 and e.name=?2");
    	query.setParameter(1, id);
    	query.setParameter(2, name);
    	try {
    		return (Employee) query.getSingleResult();
    	}catch(NoResultException e) {
    		return null;
    	}
    }
    
    public Employee deleemp(int id) {
    	Employee emp = manager.find(Employee.class, id);
    	if(emp!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		transaction.begin();
    		manager.remove(emp);
    		transaction.commit();
    		return emp;
    	}
    	return null;
    }
}
