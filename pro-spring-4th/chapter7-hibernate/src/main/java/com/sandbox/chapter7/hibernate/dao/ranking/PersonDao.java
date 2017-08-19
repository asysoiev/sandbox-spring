package com.sandbox.chapter7.hibernate.dao.ranking;

import com.sandbox.chapter7.hibernate.model.ranking.Person;

/**
 * Created by andrii on 19.08.17.
 */
public interface PersonDao {

    Person addPerson(String personName, String surname);

    Person findByName(String name);

    void save(Person person);

    Person loadById(Long id);
}
