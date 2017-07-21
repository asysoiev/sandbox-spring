package com.sandbox.chapter12.rest;

import com.sandbox.chapter12.rest.model.Contact;
import com.sandbox.chapter12.rest.model.Contacts;
import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 * Created by andrii on 09.07.17.
 */
public class ClientApp {

    private static final String SERVER_URL = "http://localhost:8080/restful";
    private static final String URL_GET_ALL_CONTACTS = SERVER_URL + "/contact/listdata";
    private static final String URL_GET_CONTACT_BY_ID = SERVER_URL + "/contact/{id}";
    private static final String URL_CREATE_CONTACT = SERVER_URL + "/contact/";
    private static final String URL_UPDATE_CONTACT = SERVER_URL + "/contact/{id}";
    private static final String URL_DELETE_CONTACT = SERVER_URL + "/contact/{id}";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/restful-client-app-context.xml");
        ctx.refresh();
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);

        System.out.println("==========Get all contacts==========");
        Contacts contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
        listContacts(contacts);

        System.out.println("==========Get Contact by ID==========");
        Contact contact = restTemplate.getForObject(URL_GET_CONTACT_BY_ID, Contact.class, 1);
        System.out.println(contact);

        System.out.println("==========Update Contact==========");
        contact = restTemplate.getForObject(URL_UPDATE_CONTACT, Contact.class, 1);
        contact.setFirstName("John Doe");
        restTemplate.put(URL_UPDATE_CONTACT, contact, 1);
        System.out.println("Updated Contact: " + contact);

        System.out.println("==========Delete Contact==========");
        restTemplate.delete(URL_DELETE_CONTACT, 1);
        System.out.println("Testing delete contact by id :");
        contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
        listContacts(contacts);

        System.out.println("==========Create Contact==========");
        System.out.println("Testing create contact :");
        Contact contactNew = new Contact();
        contactNew.setFirstName("James");
        contactNew.setLastName("Gosling");
        contactNew.setBirthDate(new DateTime());
        contactNew =
                restTemplate.postForObject(URL_CREATE_CONTACT, contactNew, Contact.class);
        System.out.println("Contact created successfully: " + contactNew);
    }

    private static void listContacts(Contacts contacts) {
        for (Contact contact : contacts.getContacts()) {
            System.out.println(contact);
        }
        System.out.println("");
    }

}
