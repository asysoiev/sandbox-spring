package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.model.Contact;

import java.util.List;

/**
 * Created by andrii on 22.04.17.
 */
public interface ContactDao {

    Contact findById(Long id);

    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    List<Contact> findByCriteriaQuery(String firstName, String lastName);

    Contact save(Contact contact);

    void delete(Contact contact);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
