package com.sandbox.chapter5.aop.proxies;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        SimpleBean target = new SimpleBeanImpl();

        Advisor advisor = new DefaultPointcutAdvisor(new PointCut(), new NoOpAdvice());
        runCGLIBTests(target, advisor);
        runCGLIBFrozenTests(target, advisor);
        runJdkTests(target, advisor);
    }

    private static void runCGLIBTests(SimpleBean target, Advisor advisor) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        System.out.println("Running CGLIB (Standard) Tests");
        test((SimpleBean) proxyFactory.getProxy());
    }

    private static void runCGLIBFrozenTests(SimpleBean target, Advisor advisor) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setFrozen(true);

        System.out.println("Running CGLIB (Frozen mode) Tests");
        test((SimpleBean) proxyFactory.getProxy());
    }

    private static void runJdkTests(SimpleBean target, Advisor advisor) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setInterfaces(SimpleBean.class);

        System.out.println("Running JDK Tests");
        test((SimpleBean) proxyFactory.getProxy());
    }

    private static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
        Advised advised = (Advised) bean;
        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
        System.out.println(">>>\n");
    }

}
