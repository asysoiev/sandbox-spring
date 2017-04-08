package com.sandbox.aop.configurations.aspectj;

import org.springframework.stereotype.Component;

/**
 * @author Andrii Sysoiev
 */
@Component("myDep")
public class MyDependency {

    public void foo(int intValue) {
        System.out.println(String.format("foo(%d)", intValue));
    }

    public void bar() {
        System.out.println("bar");
    }

}
