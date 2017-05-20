package com.sandbox.chapter9.transactions.jta;

import com.sandbox.chapter9.transactions.jta.models.Contact;
import com.sandbox.chapter9.transactions.jta.services.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactService",
                ContactService.class);

        List<Contact> contacts = contactService.findAll();
        for (Contact contactTemp : contacts) {
            System.out.println(contactTemp);
        }

        System.out.println("Find By ID: " + contactService.findById(1L));

        Contact contact = new Contact();
        contact.setFirstName("Jta");
        contact.setLastName("Manager");
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);

        contacts = contactService.findAll();
        for (Contact contactTemp : contacts) {
            System.out.println(contactTemp);
        }
    }

}
