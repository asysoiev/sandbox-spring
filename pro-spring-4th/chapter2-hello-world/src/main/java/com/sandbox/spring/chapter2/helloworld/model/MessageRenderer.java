package com.sandbox.spring.chapter2.helloworld.model;

/**
 * @author Andrii Sysoiev
 */
public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider provider);
}
