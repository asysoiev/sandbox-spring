package com.sandbox.aop.pointcuts;

/**
 * @author Andrii Sysoiev
 */
public class NameBean {

    public void foo() {
        System.out.println("Foo: ");
    }

    public void foo(int x) {
        System.out.println("Foo: " + x);
    }

    public void bar() {
        System.out.println("Bar");
    }

    public void yap() {
        System.out.println("Yap");
    }


}
