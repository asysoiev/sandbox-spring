package com.sandbox.chapter8.jpa.auditable;

import com.sandbox.chapter8.jpa.auditable.model.ContactAudit;
import com.sandbox.chapter8.jpa.auditable.service.ContactAuditService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by andrii on 09.05.17.
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        ContactAuditService contactService = ctx.getBean(
                "contactAuditService", ContactAuditService.class);
        List<ContactAudit> contacts = contactService.findAll();
        listContacts(contacts);

        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);
        contact = contactService.findById(1l);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");

        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);

        ContactAudit oldContact = contactService.findByAuditVersionId(1l, 1);
        System.out.println("");
        System.out.println("Old Contact with id 1 and rev 1:" + oldContact);
        System.out.println("");
        oldContact = contactService.findByAuditVersionId(1l, 2);
        System.out.println("");
        System.out.println("Old Contact with id 1 and rev 2:" + oldContact);
        System.out.println("");
    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (ContactAudit contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

}
