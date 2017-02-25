package com.sandbox.chapter4.lifecycle;

/**
 * @author Andrii Sysoiev
 */
public interface SimpleBean {

    String getName();

    int getAge();

    default String getInfo() {
        return "Name: " + getName() + ", age: " + getAge();
    }

}
