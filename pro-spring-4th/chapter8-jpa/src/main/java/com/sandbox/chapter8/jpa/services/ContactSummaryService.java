package com.sandbox.chapter8.jpa.services;

import com.sandbox.chapter8.jpa.model.ContactSummary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrii on 29.04.17.
 */
public interface ContactSummaryService {
    @Transactional(readOnly = true)
    List<ContactSummary> findAll();
}
