package com.demo.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.demo.entity.Person;

@Repository
public class PersonJDBCDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public PersonJDBCDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findAllWithRowMapper() {
		return jdbcTemplate.query("select * from person", new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Person(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getDate("birth_day")
				);
			}
			
		});
	}
	
	public List<Person> findAllWithLambda() {
		return jdbcTemplate.query("select * from person", (rs, index) -> {
			return new Person(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getDate("birth_day")
			);
		});
	}

}
