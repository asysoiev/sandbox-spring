package com.sandbox.chapter10.converters;

import com.sandbox.chapter10.converters.model.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("property-editor");
        ctx.load("classpath:META-INF/spring/*-context.xml");
        ctx.refresh();

        Contact chris = ctx.getBean("chris", Contact.class);
        System.out.println("Chris info: " + chris);
        Contact myContact = ctx.getBean("myContact", Contact.class);
        System.out.println("My contact info: " + myContact);
    }

}
