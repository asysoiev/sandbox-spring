package com.sandbox.chapter10.jcr349.services;

import com.sandbox.chapter10.jcr349.model.Customer;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Andrii Sysoiev
 */
public interface BeanValidationService {

    Set<ConstraintViolation<Customer>> validateCustomer(Customer customer);

}
