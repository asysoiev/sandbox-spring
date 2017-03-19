package com.sandbox.aop.pointcuts;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Andrii Sysoiev
 */
public class DynamicPointCut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static checks of method: " + method.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Dynamic checks of method: " + method.getName());

        int x = (int) args[0];
        return x != 100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> BeanTwo.class.equals(clazz);
    }
}
