package com.sandbox.chapter8.jpa.repositories;

import com.sandbox.chapter7.hibernate.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by andrii on 09.05.17.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
