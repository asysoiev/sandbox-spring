package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by andrii on 22.04.17.
 */
@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Contact.findAllWithDetail").list();
    }

    @Override
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        throw new NotImplementedException();
    }

    @Override
    public Contact findById(Long id) {
        return (Contact) sessionFactory.getCurrentSession()
                .getNamedQuery("Contact.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }

    @Override
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        throw new NotImplementedException();
    }
}
