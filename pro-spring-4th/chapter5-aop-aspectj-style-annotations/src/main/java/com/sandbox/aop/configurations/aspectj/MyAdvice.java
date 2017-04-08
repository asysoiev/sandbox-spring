package com.sandbox.aop.configurations.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Sysoiev
 */
@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.sandbox.aop.configurations.aspectj..foo*(int)) && args(intValue)")
    public void fooExecution(int intValue) {
    }

    @Pointcut("bean(myDep)")
    public void inMyDep() {
    }

    @Before("fooExecution(intValue) && inMyDep()")
    public void simpleBeforeAdvice(JoinPoint joinpoint, int intValue) {
        if (intValue != 100) {
            System.out.println("Executing Type: " + joinpoint.getSignature().getDeclaringType()
                    + " " + joinpoint.getSignature().getName() + " args: " + intValue);
        }
    }

    @Around("fooExecution(intValue) && inMyDep()")
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
