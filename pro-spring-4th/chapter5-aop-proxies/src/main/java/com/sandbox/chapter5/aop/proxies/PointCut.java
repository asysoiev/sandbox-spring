package com.sandbox.chapter5.aop.proxies;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Andrii Sysoiev
 */
public class PointCut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return ("advised".equals(method.getName()));
    }
}
