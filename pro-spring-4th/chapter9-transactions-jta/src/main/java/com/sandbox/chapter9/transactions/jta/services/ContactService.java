package com.sandbox.chapter9.transactions.jta.services;


import com.sandbox.chapter9.transactions.jta.models.Contact;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public interface ContactService {

    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);

    long countAll();

}
