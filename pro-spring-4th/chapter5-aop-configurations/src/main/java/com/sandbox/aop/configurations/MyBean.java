package com.sandbox.aop.configurations;

/**
 * @author Andrii Sysoiev
 */
public class MyBean {

    private MyDependency dependency;

    public void execute() {
        dependency.foo();
        dependency.bar();
    }

    public void setDependency(MyDependency dependency) {
        this.dependency = dependency;
    }
}
