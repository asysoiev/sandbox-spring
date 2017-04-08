package com.sandbox.aop.configurations.namespace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Andrii Sysoiev
 */
public class MyAdvice {

    public void simpleBeforeAdvice(JoinPoint joinpoint, int intValue) {
        if (intValue != 100) {
            System.out.println("Executing Type: " + joinpoint.getSignature().getDeclaringType()
                    + " " + joinpoint.getSignature().getName() + " args: " + intValue);
        }
    }

    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue)
            throws Throwable {
        System.out.println("Before execution: " +
                pjp.getSignature().getDeclaringTypeName() + " "
                + pjp.getSignature().getName()
                + " argument: " + intValue);
        Object retVal = pjp.proceed();
        System.out.println("After execution: " +
                pjp.getSignature().getDeclaringTypeName() + " "
                + pjp.getSignature().getName() + " argument: " + intValue);
        return retVal;
    }

}
