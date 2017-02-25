package com.sandbox.chapter4.lifecycle.model;

import com.sandbox.chapter4.lifecycle.SimpleBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Andrii Sysoiev
 */
public class InterfaceHandler implements SimpleBean, InitializingBean, DisposableBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Handle initialize by Interface implementation");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + InterfaceHandler.class);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Handle destroy by Interface implementation");
    }
}
