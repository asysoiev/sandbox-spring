package com.sandbox.chapter4.envvariables;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class XmlApp {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getenv("java_home"));

        Property property = ctx.getBean("property", Property.class);
        System.out.println(property.getUserHome());
        System.out.println(property.getJavaHome());
    }

}
