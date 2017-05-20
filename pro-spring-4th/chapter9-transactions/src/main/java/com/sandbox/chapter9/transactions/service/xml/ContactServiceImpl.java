package com.sandbox.chapter9.transactions.service.xml;

import com.google.common.collect.Lists;
import com.sandbox.chapter9.transactions.model.Contact;
import com.sandbox.chapter9.transactions.repository.ContactRepository;
import com.sandbox.chapter9.transactions.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public long countAll() {
        return contactRepository.countAllContacts();
    }
}
