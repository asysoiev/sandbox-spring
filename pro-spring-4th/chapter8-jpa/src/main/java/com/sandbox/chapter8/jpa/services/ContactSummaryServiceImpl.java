package com.sandbox.chapter8.jpa.services;

import com.sandbox.chapter8.jpa.model.ContactSummary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by andrii on 29.04.17.
 */
@Service("contactSummaryUntype")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<ContactSummary> findAll() {
        return entityManager
                .createQuery("select new com.sandbox.chapter8.jpa.model.ContactSummary(c.firstName, c.lastName, t.telNumber) "
                        + "from Contact c left join c.contactTelDetails t "
                        + " where t.telType='Home'", ContactSummary.class).getResultList();
    }

}
