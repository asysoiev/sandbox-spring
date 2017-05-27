package com.sandbox.chapter10.jcr349.services;

import com.sandbox.chapter10.jcr349.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Andrii Sysoiev
 */
@Service("myBeanValidationService")
public class BeanValidationServiceImpl implements BeanValidationService {

    @Autowired
    private Validator validator;

    @Override
    public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer) {
        return validator.validate(customer);
    }
}
