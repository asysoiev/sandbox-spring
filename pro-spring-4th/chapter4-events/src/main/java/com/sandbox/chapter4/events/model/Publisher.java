package com.sandbox.chapter4.events.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Andrii Sysoiev
 */
public class Publisher implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publsih(String msg) {
        applicationContext.publishEvent(new MessageEvent(this, msg));
    }
}
