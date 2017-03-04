package com.sandbox.chapter4.jcr330;

import com.sandbox.spring.chapter3.dependency.services.MessageProvider;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Andrii Sysoiev
 */
@Singleton
@Named("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider() {
        message = "DEFAULT MESSAGE";
    }

    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
