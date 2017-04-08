package com.sandbox.aop.configurations.namespace;

/**
 * @author Andrii Sysoiev
 */
public class MyDependency {

    public void foo(int value) {
        System.out.println(String.format("foo(%d)", value));
    }

    public void bar() {
        System.out.println("bar");
    }

}
