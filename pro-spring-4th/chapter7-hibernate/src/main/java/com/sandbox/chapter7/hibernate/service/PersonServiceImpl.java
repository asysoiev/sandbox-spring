package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.dao.ranking.PersonDao;
import com.sandbox.chapter7.hibernate.model.ranking.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andrii on 19.08.17.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person addPerson(String name, String surname) {
        return personDao.addPerson(name, surname);
    }

    @Override
    public void savePerson(Person person) {
        personDao.save(person);
    }

    @Override
    public Person loadById(Long id) {
        return personDao.loadById(id);
    }
}
