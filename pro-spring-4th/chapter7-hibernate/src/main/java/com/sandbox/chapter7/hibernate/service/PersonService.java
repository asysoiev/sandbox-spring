package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.model.ranking.Person;

/**
 * Created by andrii on 19.08.17.
 */
public interface PersonService {

    Person addPerson(String name, String surname);

    void savePerson(Person person);

    Person loadById(Long id);
}
