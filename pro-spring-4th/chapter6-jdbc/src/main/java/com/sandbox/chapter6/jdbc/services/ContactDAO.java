package com.sandbox.chapter6.jdbc.services;

import com.sandbox.chapter6.jdbc.model.Contact;

import java.util.List;

/**
 * Created by andrii on 17.04.17.
 */
public interface ContactDAO {

    List<Contact> findAll();

    List<Contact> findAllWithDetails();
    List<Contact> findByFirstName(String firstName);
    String findFirstNameById(long id);
    String findLastNameById(long id);
    void insert(Contact contact);

    void insertContactWithDetail(Contact contact);

    void update(Contact contact);
    void delete(long contactId);

}
