package com.sandbox.chapter10.validation;

import com.sandbox.chapter10.validation.model.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        Contact contact = new Contact();
        contact.setFirstName(null);
        contact.setLastName("Schaefer");

        Validator contactValidator = ctx.getBean("contactValidator", Validator.class);
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact, "Chris");
        ValidationUtils.invokeValidator(contactValidator, contact, result);
        List<ObjectError> errors = result.getAllErrors();
        System.out.println("No of validation errors: " + errors.size());
        for (ObjectError error : errors) {
            System.out.println(error.getCode());
        }
    }

}
