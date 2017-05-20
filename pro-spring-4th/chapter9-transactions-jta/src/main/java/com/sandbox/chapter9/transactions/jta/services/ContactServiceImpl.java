package com.sandbox.chapter9.transactions.jta.services;

import com.sandbox.chapter9.transactions.jta.models.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;
    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        TypedQuery<Contact> query = emB.createNamedQuery("Contact.findAll", Contact.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        TypedQuery<Contact> query = emA.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        Contact contactB = new Contact();
        contactB.setFirstName(contact.getFirstName());
        contactB.setLastName(contact.getLastName());
        if (contact.getId() == null) {
            emA.persist(contact);
            emB.persist(contactB);
            // throw new JpaSystemException(new PersistenceException());
        } else {
            emA.merge(contact);
            emB.merge(contact);
        }
        return contact;
    }

    @Override
    public long countAll() {
        return 0;
    }
}
