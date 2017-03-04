package com.sandbox.chapter4.jcr330;

import com.sandbox.spring.chapter3.dependency.services.MessageProvider;
import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Andrii Sysoiev
 */
@Singleton
@Named("messageRenderer")
public class StandartOutMessageRenderer implements MessageRenderer {

    @Inject
    @Named("messageProvider")
    private MessageProvider messageProvider;

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        messageProvider = provider;
    }
}
