package com.sandbox.chapter9.transactions;

import com.sandbox.chapter9.transactions.model.Contact;
import com.sandbox.chapter9.transactions.service.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("annotation");
        ctx.getEnvironment().setActiveProfiles("xml");
        ctx.load("classpath:META-INF/spring/*-app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        List<Contact> contacts = contactService.findAll();
        for (Contact contactTemp : contacts) {
            System.out.println(contactTemp);
        }
        Contact contact = contactService.findById(1L);
        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);
        System.out.println("Contact count: " + contactService.countAll());
    }

}
