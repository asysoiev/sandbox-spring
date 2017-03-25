package com.sandbox.aop.pointcuts;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Andrii Sysoiev
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
