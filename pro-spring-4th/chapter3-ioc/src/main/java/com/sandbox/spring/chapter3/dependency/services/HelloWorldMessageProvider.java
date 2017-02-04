package com.sandbox.spring.chapter3.dependency.services;

/**
 * @author Andrii Sysoiev
 */
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello World!";
    }
}
