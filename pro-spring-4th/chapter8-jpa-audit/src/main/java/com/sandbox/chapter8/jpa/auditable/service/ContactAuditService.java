package com.sandbox.chapter8.jpa.auditable.service;

import com.sandbox.chapter8.jpa.auditable.model.ContactAudit;

import java.util.List;

/**
 * Created by andrii on 09.05.17.
 */
public interface ContactAuditService {
    List<ContactAudit> findAll();

    ContactAudit findById(Long id);

    void save(ContactAudit value);

    ContactAudit findByAuditVersionId(Long id, int versionId);
}
