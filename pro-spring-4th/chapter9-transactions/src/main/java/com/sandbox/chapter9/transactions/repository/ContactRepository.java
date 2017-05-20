package com.sandbox.chapter9.transactions.repository;

import com.sandbox.chapter9.transactions.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Andrii Sysoiev
 */
public interface ContactRepository extends CrudRepository<Long, Contact> {
}
