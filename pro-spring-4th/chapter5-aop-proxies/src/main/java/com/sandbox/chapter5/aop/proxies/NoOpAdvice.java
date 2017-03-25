package com.sandbox.chapter5.aop.proxies;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Andrii Sysoiev
 */
public class NoOpAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //no op
    }
}
