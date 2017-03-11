package com.sandbox.chapter5.aop.secure;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        SecureBean secureBean = getSecureBean();

        SecurityManager mgr = new SecurityManager();

        mgr.login("chris", "pwd");
        secureBean.writeMessage();
        mgr.logout();
        try {
            mgr.login("invaliduser", "pwd");
            secureBean.writeMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            secureBean.writeMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(new SecureAdvice());

        return (SecureBean) pf.getProxy();
    }

}
