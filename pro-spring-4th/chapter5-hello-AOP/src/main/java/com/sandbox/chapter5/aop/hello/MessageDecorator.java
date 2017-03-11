package com.sandbox.chapter5.aop.hello;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Andrii Sysoiev
 */
public class MessageDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("Hello ");
        Object proceed = invocation.proceed();
        System.out.print("!");
        return proceed;
    }
}
