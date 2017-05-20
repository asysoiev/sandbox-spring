package com.sandbox.chapter9.transactions.service.annotation;

import com.google.common.collect.Lists;
import com.sandbox.chapter9.transactions.model.Contact;
import com.sandbox.chapter9.transactions.repository.ContactRepository;
import com.sandbox.chapter9.transactions.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public long countAll() {
        return contactRepository.countAllContacts();
    }
}
