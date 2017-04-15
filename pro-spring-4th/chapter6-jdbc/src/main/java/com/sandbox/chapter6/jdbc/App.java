package com.sandbox.chapter6.jdbc;

import com.sandbox.chapter6.jdbc.model.Contact;
import com.sandbox.chapter6.jdbc.model.ContactTelDetail;
import com.sandbox.chapter6.jdbc.services.ContactDAO;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by andrii on 17.04.17.
 */
public class App {

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/*-config.xml");
        context.refresh();

        ContactDAO contactDAO = context.getBean("contactDAO", ContactDAO.class);

        System.out.println("Listing initial contact data");
        List<Contact> all = contactDAO.findAll();
        for (Contact contact : all) {
            System.out.println(contact);
        }

        System.out.println();
        System.out.println("Insert new Contact");
        Contact newContact = new Contact();
        newContact.setFirstName("Andrii");
        newContact.setLastName("Sysoiev");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        newContact.setBirthDate(simpleDateFormat.parse("1989-12-05"));
        ContactTelDetail detail1 = new ContactTelDetail();
        detail1.setTelType("HOME");
        detail1.setTelNumber("1");
        newContact.addTelDetail(detail1);
        ContactTelDetail detail2 = new ContactTelDetail();
        detail2.setTelType("WORK");
        detail2.setTelNumber("2");
        newContact.addTelDetail(detail2);
        ContactTelDetail detail3 = new ContactTelDetail();
        detail3.setTelType("ADDITIONAL");
        detail3.setTelNumber("3");
        newContact.addTelDetail(detail3);
        contactDAO.insertContactWithDetail(newContact);
        System.out.println("Listing contact data");

        all = contactDAO.findAllWithDetails();
        for (Contact contact : all) {
            System.out.println(contact);
            for (ContactTelDetail telDetail : contact.getTelDetails()) {
                System.out.println("---" + telDetail);
            }
        }

        System.out.println();
//        long newId = 1;
        long newId = newContact.getId();
        String firstName = contactDAO.findFirstNameById(newId);
        System.out.println(String.format("First name: %s for id: %s", firstName, newId));
        String lastName = contactDAO.findLastNameById(newId);
        System.out.println(String.format("Last name: %s for id: %s", lastName, newId));
        List<Contact> byFirstName = contactDAO.findByFirstName(firstName);
        System.out.println(String.format("Contacts by first name: %s", firstName));
        for (Contact contact : byFirstName) {
            System.out.println(contact);
        }

        newContact.setFirstName("Vasya");
        contactDAO.update(newContact);
        System.out.println(String.format("Contacts after update"));
        all = contactDAO.findAll();
        for (Contact contact : all) {
            System.out.println(contact);
        }

        System.out.println();
        System.out.println("Delete created contact");
        contactDAO.delete(newContact.getId());
        System.out.println("Listing contact data");

        all = contactDAO.findAll();
        for (Contact contact : all) {
            System.out.println(contact);
        }
    }

}
