package com.sandbox.chapter5.aop.after;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Andrii Sysoiev
 */
public class AfterReturnAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if (target instanceof KeyGenerator
                && "getKey".equals(method.getName())
                && KeyGenerator.WEAK_KEY == ((Long) returnValue).longValue()) {
            throw new SecurityException(
                    "Key Generator generated a weak key. Try again");
        }
    }
}
