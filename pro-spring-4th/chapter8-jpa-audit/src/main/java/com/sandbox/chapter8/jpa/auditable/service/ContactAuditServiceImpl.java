package com.sandbox.chapter8.jpa.auditable.service;

import com.google.common.collect.Lists;
import com.sandbox.chapter8.jpa.auditable.model.ContactAudit;
import com.sandbox.chapter8.jpa.auditable.repository.ContactAuditRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by andrii on 09.05.17.
 */
@Transactional
@Repository
@Service(value = "contactAuditService")
public class ContactAuditServiceImpl implements ContactAuditService {

    @Autowired
    private ContactAuditRepository contactAuditRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }

    @Override
    public void save(ContactAudit value) {
        contactAuditRepository.save(value);
    }

    @Override
    public ContactAudit findByAuditVersionId(Long id, int versionId) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(ContactAudit.class, id, versionId);
    }
}
