package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.model.Contact;

import java.util.List;

/**
 * Created by andrii on 22.04.17.
 */
public interface ContactDao {
    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);

}
