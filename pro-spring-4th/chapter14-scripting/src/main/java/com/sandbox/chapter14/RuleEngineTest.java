package com.sandbox.chapter14;

import com.sandbox.chapter14.model.Contact;
import com.sandbox.chapter14.services.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by andrii on 24.09.17.
 */
public class RuleEngineTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        Contact contact = new Contact();
        contact.setId(1l);
        contact.setFirstName("Chris");
        contact.setLastName("Schaefer");
        contact.setBirthDate(LocalDate.from(DateTimeFormatter.ISO_DATE.parse("1981-05-03")));
        contactService.applyRule(contact);
        System.out.println("Contact: " + contact);
        try {
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        contactService.applyRule(contact);
        System.out.println("Contact: " + contact);
    }

}
