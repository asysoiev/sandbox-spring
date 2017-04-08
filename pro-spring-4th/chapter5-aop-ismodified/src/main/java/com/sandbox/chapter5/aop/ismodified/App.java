package com.sandbox.chapter5.aop.ismodified;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        TargetBean targetBean = new TargetBean();
        targetBean.setName("Andrew Sysoiev");

        Advisor isModifiedAdvisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(targetBean);
        pf.addAdvisor(isModifiedAdvisor);
        pf.setOptimize(true);

        Object proxy = pf.getProxy();
        System.out.println("Is TargetBean: " + (proxy instanceof TargetBean));
        System.out.println("Is IsModified: " + (proxy instanceof IsModified));

        TargetBean targetBeanProxy = (TargetBean) proxy;
        IsModified isModifiedProxy = (IsModified) proxy;

        System.out.println("Has been modified: " + isModifiedProxy.isModified());

        targetBeanProxy.setName("Andrew Sysoiev");
        System.out.println("Has been modified: " + isModifiedProxy.isModified());

        targetBeanProxy.setName("Andrii Sysoiev");
        System.out.println("Has been modified: " + isModifiedProxy.isModified());
    }

}
