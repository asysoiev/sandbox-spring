package com.sandbox.chapter5.aop.after;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(keyGenerator);
        pf.addAdvice(new AfterReturnAdvice());

        KeyGenerator proxy = (KeyGenerator) pf.getProxy();

        for (int x = 0; x < 10; x++) {
            try {
                long key = proxy.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException ex) {
                System.out.println("Weak Key Generated!");
            }
        }
    }

}
