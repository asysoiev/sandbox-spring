package com.sandbox.chapter12.rest;

import com.sandbox.chapter12.rest.model.Contact;
import com.sandbox.chapter12.rest.model.Contacts;
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
        System.out.println("Testing retrieve all contacts:");
        Contacts contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
        listContacts(contacts);
    }

    private static void listContacts(Contacts contacts) {
        for (Contact contact : contacts.getContacts()) {
            System.out.println(contact);
        }
        System.out.println("");
    }

}
