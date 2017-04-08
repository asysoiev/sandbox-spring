package com.sandbox.chapter5.aop.aspectj;

/**
 * @author Andrii Sysoiev
 */
public class MessageWriter {

    public void writeMessage() {
        System.out.println("message");
    }

    public void foo() {
        System.out.println("foo");
    }

}
