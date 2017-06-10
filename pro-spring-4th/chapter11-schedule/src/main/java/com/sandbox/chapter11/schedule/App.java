package com.sandbox.chapter11.schedule;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by andrii on 10.06.17.
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("annotation");
        ctx.load("classpath:META-INF/spring/*-app-context.xml");
        ctx.refresh();
        while (true) {
        }
    }

}
