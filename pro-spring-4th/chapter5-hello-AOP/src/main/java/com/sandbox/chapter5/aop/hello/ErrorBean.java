package com.sandbox.chapter5.aop.hello;

/**
 * @author Andrii Sysoiev
 */
public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bar");
    }

}
