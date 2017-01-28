package com.sandbox.spring.chapter2.helloworld.model;

/**
 * @author Andrii Sysoiev
 */
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello World!";
    }
}
