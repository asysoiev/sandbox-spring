package com.sandbox.chapter5.aop.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * @author Andrii Sysoiev
 */
public class ProfilereAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(invocation.getMethod().getName());
        Object proceed = invocation.proceed();
        stopWatch.stop();
        dumpData(invocation, stopWatch.getTotalTimeMillis());
        return proceed;
    }

    private void dumpData(MethodInvocation invocation, long totalTimeMillis) {
        System.out.println("Class: " + invocation.getThis());
        System.out.println("Method: " + invocation.getMethod());
//        System.out.println("Method: " + invocation.getMethod().getName());
        System.out.println("Params: ");
        for (int i = 0; i < invocation.getArguments().length; i++) {
            System.out.println(" > " + invocation.getArguments()[i]);
        }
        System.out.println("Time: " + totalTimeMillis + "(ms)");
    }
}
