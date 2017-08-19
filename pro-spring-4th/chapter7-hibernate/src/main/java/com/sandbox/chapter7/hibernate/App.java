package com.sandbox.chapter7.hibernate;

import com.sandbox.chapter7.hibernate.dao.contact.ContactDao;
import com.sandbox.chapter7.hibernate.model.contact.Contact;
import com.sandbox.chapter7.hibernate.model.contact.ContactTelDetail;
import com.sandbox.chapter7.hibernate.model.contact.Hobby;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by andrii on 22.04.17.
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("hibernate");
        ctx.load("classpath:META-INF/spring/app-config.xml");
        ctx.refresh();


        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact newContact = new Contact();
        newContact.setFirstName("Michael");
        newContact.setLastName("Jackson");
        newContact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail =
                new ContactTelDetail("Home", "1111111111");
        newContact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
//        contactTelDetail.setContact(newContact);//mappedBy magic
        newContact.addContactTelDetail(contactTelDetail);
        contactDao.save(newContact);
        listContacts(contactDao.findAllWithDetail());

        System.out.println("LAZY LOADING");
        List<Contact> all = contactDao.findAll();
        Contact contact1 = all.get(0);
        System.out.println("LAZY LOADING 1");
        Set<ContactTelDetail> contactTelDetails = contact1.getContactTelDetails();
        for (ContactTelDetail telDetail : contactTelDetails) {
            System.out.println("telDetail: " + telDetail);
        }
        System.out.println("LAZY LOADING");

        System.out.println("");
        System.out.println("Delete contact: " + newContact);
        contactDao.delete(newContact);
        listContacts(contactDao.findAllWithDetail());

        long id = 1;
        Contact contact = contactDao.findById(id);
        System.out.println("");
        System.out.println(String.format("Contact with id %d: %s", id, contact));
        System.out.println("");

        System.out.println("Update contact: " + contact);
        contact.setFirstName("Kim Fung");
        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
        ContactTelDetail toDeleteContactTel = null;
        for (ContactTelDetail contactTel : contactTels) {
            if (contactTel.getTelType().equals("Home")) {
                toDeleteContactTel = contactTel;
            }
        }
        contact.removeContactTelDetail(toDeleteContactTel);
        contactDao.save(contact);

        listContacts(contactDao.findAllWithDetail());
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail :
                        contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }

}
