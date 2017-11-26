package com.demo.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.demo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person p) {
		return entityManager.merge(p);
	}
	
	public Person insert(Person p) {
		return entityManager.merge(p);
	}
}
