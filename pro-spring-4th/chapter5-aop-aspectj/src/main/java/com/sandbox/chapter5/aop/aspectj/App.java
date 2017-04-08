package com.sandbox.chapter5.aop.aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/aspectj-context.xml");
        context.refresh();

        MessageWriter messageWriter = new MessageWriter();
        messageWriter.writeMessage();
        messageWriter.foo();
    }
}
