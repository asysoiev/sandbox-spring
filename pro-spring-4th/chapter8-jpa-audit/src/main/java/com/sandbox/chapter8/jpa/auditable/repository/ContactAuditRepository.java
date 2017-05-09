package com.sandbox.chapter8.jpa.auditable.repository;

import com.sandbox.chapter8.jpa.auditable.model.ContactAudit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by andrii on 09.05.17.
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {
}
