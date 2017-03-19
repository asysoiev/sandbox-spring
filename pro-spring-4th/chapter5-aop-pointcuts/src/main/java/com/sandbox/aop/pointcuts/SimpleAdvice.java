package com.sandbox.aop.pointcuts;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Andrii Sysoiev
 */
public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(">> Intercept:");
        Object result = invocation.proceed();
        System.out.println("<< Done");
        return result;
    }
}
