package com.sandbox.chapter8.jpa.services;

import com.sandbox.chapter7.hibernate.model.Contact;
import com.sandbox.chapter7.hibernate.service.ContactDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by andrii on 29.04.17.
 */
@Service("contactDao")
@Repository
@Transactional
public class JpaContactService implements ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        Query query = entityManager.createNativeQuery("select id, first_name, last_name, birth_date, version from contact where id=:id", "contactResult");
        return query.getResultList();
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return entityManager.createNamedQuery("Contact.findAllWithDetail").getResultList();
    }

    @Override
    public Contact findById(Long id) {
        TypedQuery<Contact> query = entityManager.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            entityManager.persist(contact);
        } else {
            entityManager.merge(contact);
        }
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = entityManager.merge(contact);
        entityManager.remove(mergedContact);
    }
}
