package com.mitraiscdc.databasedemo.dao;

import com.mitraiscdc.databasedemo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> findAll();
    Person findById(int id);
    int deletebyId(int id);
    int insert(Person person);
    int update(Person person);
}
