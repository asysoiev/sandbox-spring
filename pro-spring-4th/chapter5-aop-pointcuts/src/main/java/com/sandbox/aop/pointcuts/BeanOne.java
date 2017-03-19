package com.sandbox.aop.pointcuts;

/**
 * @author Andrii Sysoiev
 */
public class BeanOne {

    public void foo() {
        System.out.println("Foo");
    }

    @AdviceRequired
    public void bar() {
        System.out.println("Bar");
    }

}
