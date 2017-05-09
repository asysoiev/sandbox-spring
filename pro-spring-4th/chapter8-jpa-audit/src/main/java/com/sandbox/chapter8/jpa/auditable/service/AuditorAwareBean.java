package com.sandbox.chapter8.jpa.auditable.service;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by andrii on 09.05.17.
 */
public class AuditorAwareBean implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        return "Andrii Sysoiev";
    }
}
