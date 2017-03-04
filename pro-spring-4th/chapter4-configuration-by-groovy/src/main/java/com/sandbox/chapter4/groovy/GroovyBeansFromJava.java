package com.sandbox.chapter4.groovy;

import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class GroovyBeansFromJava {

    public static void main(String[] args) {
        GenericGroovyApplicationContext ctx = new GenericGroovyApplicationContext();
        ctx.load("classpath:beans.groovy");
        ctx.refresh();

        Contact contact = ctx.getBean("contact", Contact.class);
        System.out.println(contact);
    }

}
