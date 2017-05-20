package com.sandbox.chapter9.transactions.repository;

import com.sandbox.chapter9.transactions.model.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Andrii Sysoiev
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("select count(c) from Contact c")
    Long countAllContacts();

}
