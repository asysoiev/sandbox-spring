package com.sandbox.spring.chapter3.methodinjection.replacement;

/**
 * @author Andrii Sysoiev
 */
public /*final*/class ReplacementTarget {

    public String formatMessage(String msg) {
        return "<h1>" + msg + "</h1>";
    }

    public String formatMessage(Object msg) {
        return "<h1>" + msg + "</h1>";
    }

}
