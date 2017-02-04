package com.sandbox.chapter3.spel;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();
        InjectSimpleSpel simple = (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
        System.out.println(simple.renderInfo());
    }

}
