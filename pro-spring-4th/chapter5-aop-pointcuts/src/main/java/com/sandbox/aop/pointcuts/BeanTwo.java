package com.sandbox.aop.pointcuts;

/**
 * @author Andrii Sysoiev
 */
public class BeanTwo {

    public void foo(int x) {
        System.out.println("Foo: " + x);
    }

    public void bar() {
        System.out.println("Bar");
    }

}
