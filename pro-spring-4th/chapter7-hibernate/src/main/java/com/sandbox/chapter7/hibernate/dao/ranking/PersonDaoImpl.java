package com.sandbox.chapter7.hibernate.dao.ranking;

import com.sandbox.chapter7.hibernate.model.ranking.Person;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by andrii on 19.08.17.
 */
@Transactional
@Repository
public class PersonDaoImpl implements PersonDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Person addPerson(String name, String surname) {
        Person newPerson = new Person(name, surname);
        sessionFactory.getCurrentSession().saveOrUpdate(newPerson);
        return newPerson;
    }

    @Transactional(readOnly = true)
    @Override
    public Person findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Person p where p.name=:name");
        query.setParameter("name", name);
        Person result = (Person) query.getSingleResult();
        return result;
    }
}
