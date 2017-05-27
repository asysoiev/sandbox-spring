package com.sandbox.chapter10.jcr349;

import com.sandbox.chapter10.jcr349.model.Customer;
import com.sandbox.chapter10.jcr349.services.BeanValidationService;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        BeanValidationService myBeanValidationService = ctx.getBean("myBeanValidationService", BeanValidationService.class);

        Customer customer = new Customer();
        customer.setFirstName("C");
        customer.setLastName("Schaefer");
        customer.setCustomerType(null);
        customer.setGender(null);
        validateCustomer(customer, myBeanValidationService);
    }

    private static void validateCustomer(Customer customer, BeanValidationService myBeanValidationService) {
        Set<ConstraintViolation<Customer>> violations =
                new HashSet<ConstraintViolation<Customer>>();
        violations = myBeanValidationService.validateCustomer(customer);
        listViolations(violations);
    }

    private static void listViolations(Set<ConstraintViolation<Customer>> violations) {
        System.out.println("No. of violations: " + violations.size());
        for (ConstraintViolation<Customer> violation : violations) {
            System.out.println("Validation error for property: " +
                    violation.getPropertyPath()
                    + " with value: " + violation.getInvalidValue()
                    + " with error message: " + violation.getMessage());
        }
    }

}
