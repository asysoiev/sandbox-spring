package com.sandbox.spring.chapter3.dependency.services;

/**
 * @author Andrii Sysoiev
 */
public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider provider);
}
