package com.mitraiscdc.databasedemo.dao;

import com.mitraiscdc.databasedemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public int deletebyId(int id) {
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    @Override
    public int insert(Person person) {
        return jdbcTemplate.update("insert into person(id, name, location, birthdate) value(?,?,?,?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())});
    }

    @Override
    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birthdate = ?" +
                        "where id = ?",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
                person.getId()});
    }
}
