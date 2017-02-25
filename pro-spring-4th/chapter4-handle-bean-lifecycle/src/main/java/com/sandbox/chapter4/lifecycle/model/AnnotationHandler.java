package com.sandbox.chapter4.lifecycle.model;

import com.sandbox.chapter4.lifecycle.SimpleBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Andrii Sysoiev
 */
public class AnnotationHandler implements SimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Handle initialize by Annotation");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + AnnotationHandler.class);
        }
    }

    @PreDestroy
    protected void destroy() {
        System.out.println("Handle destroy by Annotation");
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
}
