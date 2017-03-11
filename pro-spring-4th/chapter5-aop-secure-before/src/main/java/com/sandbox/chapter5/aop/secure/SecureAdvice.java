package com.sandbox.chapter5.aop.secure;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Andrii Sysoiev
 */
public class SecureAdvice implements MethodBeforeAdvice {

    private final SecurityManager securityManager;

    public SecureAdvice() {
        securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo user = securityManager.getUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException(
                    "You must login before attempting to invoke the method: "
                            + method.getName());
        } else if ("chris".equals(user.getLogin())) {
            System.out.println("Logged in user is chris - OKAY!");
        } else {
            System.out.println("Logged in user is " + user.getLogin()
                    + " NOT GOOD :(");
            throw new SecurityException("User " + user.getLogin()
                    + " is not allowed access to method " + method.getName());
        }
    }
}
