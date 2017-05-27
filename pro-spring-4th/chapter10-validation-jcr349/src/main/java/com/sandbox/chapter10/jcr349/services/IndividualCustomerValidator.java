package com.sandbox.chapter10.jcr349.services;

import com.sandbox.chapter10.jcr349.model.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Andrii Sysoiev
 */
public class IndividualCustomerValidator implements ConstraintValidator<CheckIndividualCustomer, Customer> {
    public void initialize(CheckIndividualCustomer constraint) {
    }

    public boolean isValid(Customer customer, ConstraintValidatorContext context) {
        boolean result = true;
        if (customer.getCustomerType() != null &&
                (customer.isIndividualCustomer() && (customer.getLastName() == null ||
                        customer.getGender() == null))) {
            result = false;
        }
        return result;
    }
}
