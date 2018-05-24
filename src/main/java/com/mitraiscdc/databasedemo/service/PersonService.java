package com.mitraiscdc.databasedemo.service;

import com.mitraiscdc.databasedemo.dao.PersonDao;
import com.mitraiscdc.databasedemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getPeople() {
        return personDao.findAll();
    }

    public Person getPersonById(int id) {
        try {
            return personDao.findById(id);
        } catch (Exception e) {
            throw new NotFoundException("person " + id + " not found");
        }
    }

    public int updatePerson(Person person) {
        Person personById = getPersonById(person.getId());

        if (personById != null) {
            return personDao.update(person);
        }

        throw new NotFoundException("person " + person.getId() + "not found");
    }

    public int deletePerson(int id) {
        try {
            Person person = personDao.findById(id);
            return personDao.deletebyId(person.getId());
        } catch (Exception e) {
            throw new NotFoundException("person " + id + "not found");
        }
    }

    public int insertPerson(Person person) {
        return personDao.insert(person);
    }
}
