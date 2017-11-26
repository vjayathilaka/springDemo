package com.demo.demo;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.demo.entity.Person;
import com.demo.demo.jdbc.PersonJDBCDao;
import com.demo.demo.jpa.PersonJpaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//@Autowired
	//PersonJDBCDao dao;
	@Autowired
	PersonJpaRepository jpa;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("JDBC");
//		logger.info("All users -> {} " + dao.findAll());
//		logger.info("All users with rowmapper -> {} " + dao.findAllWithRowMapper());
//		logger.info("All users with lambda -> {} " + dao.findAllWithLambda());
		logger.info("\n\nJPA");
		logger.info("Person by Id -> {}" + jpa.findById(10001));
		logger.info("Person by Id -> {}" + jpa.update(new Person(1003, "nalin", new Date(0))));
		logger.info("Person by Id -> {}" + jpa.insert(new Person("arjuna", new Date(0))));
		
	}
}
