package com.jsp.employeeapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.employeeapp.dto.Employee;
import java.util.*;

@Repository
public class EmployeeDao {
	@Autowired
	private EntityManager entityManager;

	public Employee saveEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		entityManager.persist(employee);
		transaction.begin();
		transaction.commit();
		return employee;
	}

	public Employee updateEmployee(Employee employee) {
		Employee dbemployee = entityManager.find(Employee.class, employee.getId());
		if (dbemployee != null) {
			dbemployee.setDesg(employee.getDesg());
			dbemployee.setEmail(employee.getEmail());
			dbemployee.setGender(employee.getGender());
			dbemployee.setName(employee.getName());
			dbemployee.setPassword(employee.getPassword());
			dbemployee.setPhone(employee.getPhone());
			dbemployee.setSalary(employee.getSalary());
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			transaction.commit();
			return dbemployee;
		} else {
			return null;
		}

	}
	
	

	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	public Employee verify(long phone, String password) {
		Query query = entityManager.createQuery("select e from Employee e where e.phone=?1 and e.password=?2");
		query.setParameter(1, phone);
		query.setParameter(2, password);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Employee verify(String email, String password) {
		Query query = entityManager.createQuery("select e from Employee e where e.email=?1 and e.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public Employee verify(int id, String password) {
		Query query = entityManager.createQuery("select e from Employee e where e.id=?1 and e.password=?2");
		query.setParameter(1, id);
		query.setParameter(2, password);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public Employee deleteEmployee(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		if(emp!=null) {
			EntityTransaction transaction = entityManager.getTransaction();
			entityManager.remove(emp);
			transaction.begin();
		    transaction.commit();
		    return emp;
			
		}
		return null;
	}
	
	
	public List<Employee> fetchall(){
		Query query = entityManager.createQuery("select e from Employee e");
		
		return query.getResultList();
	}
	

}
