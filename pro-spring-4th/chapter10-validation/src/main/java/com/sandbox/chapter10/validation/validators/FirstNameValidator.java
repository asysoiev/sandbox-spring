package com.sandbox.chapter10.validation.validators;

import com.sandbox.chapter10.validation.model.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Andrii Sysoiev
 */
@Component("contactValidator")
public class FirstNameValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contact.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "First name is empty");
    }
}
