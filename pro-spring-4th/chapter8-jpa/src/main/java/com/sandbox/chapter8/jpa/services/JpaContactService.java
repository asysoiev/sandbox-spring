package com.sandbox.chapter8.jpa.services;

import com.google.common.collect.Lists;
import com.sandbox.chapter7.hibernate.dao.contact.ContactDao;
import com.sandbox.chapter7.hibernate.model.Contact_;
import com.sandbox.chapter7.hibernate.model.contact.Contact;
import com.sandbox.chapter8.jpa.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
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
    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
//        Query query = entityManager.createNativeQuery("select id, first_name, last_name, birth_date, version from contact where id=:id", "contactResult");
//        return query.getResultList();
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return entityManager.createNamedQuery("Contact.findAllWithDetail").getResultList();
    }

    @Override
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
        Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
        contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
        criteriaQuery.select(contactRoot).distinct(true);
        Predicate criteria = cb.conjunction();
        if (firstName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.firstName),
                    firstName);
            criteria = cb.and(criteria, p);
        }
        if (lastName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.lastName),
                    lastName);
            criteria = cb.and(criteria, p);
        }
        criteriaQuery.where(criteria);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Contact findById(Long id) {
//        TypedQuery<Contact> query = entityManager.createNamedQuery("Contact.findById", Contact.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();
        return contactRepository.findOne(id);
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

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
