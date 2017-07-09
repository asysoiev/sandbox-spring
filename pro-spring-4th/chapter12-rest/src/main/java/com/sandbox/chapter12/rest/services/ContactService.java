package com.sandbox.chapter12.rest.services;

import com.sandbox.chapter12.rest.model.Contact;

import java.util.List;

/**
 * Created by andrii on 10.06.17.
 */
public interface ContactService {

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);

}
