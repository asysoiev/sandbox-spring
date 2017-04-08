package com.sandbox.aop.configurations;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/proxy-factory-bean-context.xml");
        context.refresh();

        MyBean myBean1 = context.getBean("myBean1", MyBean.class);
        MyBean myBean2 = context.getBean("myBean2", MyBean.class);

        System.out.println("Bean 1");
        myBean1.execute();

        System.out.println("Bean 2");
        myBean2.execute();
    }

}
