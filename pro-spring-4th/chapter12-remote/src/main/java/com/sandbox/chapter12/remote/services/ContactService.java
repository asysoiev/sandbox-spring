package com.sandbox.chapter12.remote.services;

import com.sandbox.chapter12.remote.models.Contact;

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
