package com.sandbox.chapter5.aop.ismodified;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Andrii Sysoiev
 */
public class IsModifiedInterceptor extends DelegatingIntroductionInterceptor implements IsModified {

    private boolean modified;
    /**
     * key - getter
     * value - setter
     */
    private Map<Method, Method> methodCache = new HashMap<>();

    @Override
    public boolean isModified() {
        return modified;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (!modified) {
            if (invocation.getMethod().getName().startsWith("set")
                    && invocation.getArguments().length == 1) {
                Method getter = getGetter(invocation.getMethod());
                if (getter != null) {
                    Object nevValue = invocation.getArguments()[0];
                    Object oldValue = getter.invoke(invocation.getThis(), null);

                    modified = !Objects.equals(nevValue, oldValue);
                }
            }
        }
        return super.invoke(invocation);
    }

    private Method getGetter(Method setter) {
        Method getter = methodCache.get(setter);
        if (getter != null) {
            return getter;
        }

        String getterName = setter.getName().replaceFirst("set", "get");

        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);

            synchronized (methodCache) {
                methodCache.put(setter, getter);
            }
        } catch (NoSuchMethodException e) {
            System.out.println(String.format("Getter for %s hasn't found.", setter.getName()));
        }
        return getter;
    }
}
