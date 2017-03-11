package com.sandbox.chapter5.aop.hello;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        //order is important, or receive pos
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.addAdvice(new SimpleAfterAdvice());
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();

        System.out.println("ThrowAdvice simple");
        ProxyFactory pfE = new ProxyFactory();
        pfE.addAdvice(new SimpleThrowsAdvice());
        pfE.setTarget(new ErrorBean());
        ErrorBean errorBean = (ErrorBean) pfE.getProxy();
        try {
            errorBean.errorProneMethod();
        } catch (Exception e) {

        }

        try {
            errorBean.otherErrorProneMethod();
        } catch (IllegalArgumentException e) {

        }
    }

}
