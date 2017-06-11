package com.sandbox.chapter12.remote.repositories;

import com.sandbox.chapter12.remote.models.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by andrii on 10.06.17.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);

}
