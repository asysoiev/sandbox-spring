package com.sandbox.aop.configurations.namespace;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/namesspace-aop-context.xml");
        context.refresh();

        MyBean myBean = context.getBean("myBean", MyBean.class);
        myBean.execute();
    }

}
