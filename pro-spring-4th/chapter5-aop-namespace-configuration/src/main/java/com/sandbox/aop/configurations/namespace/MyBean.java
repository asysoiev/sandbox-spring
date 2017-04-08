package com.sandbox.aop.configurations.namespace;

/**
 * @author Andrii Sysoiev
 */
public class MyBean {

    private MyDependency dependency;

    public void execute() {
        dependency.foo(100);
        dependency.foo(101);
        dependency.bar();
    }

    public void setDependency(MyDependency dependency) {
        this.dependency = dependency;
    }
}
