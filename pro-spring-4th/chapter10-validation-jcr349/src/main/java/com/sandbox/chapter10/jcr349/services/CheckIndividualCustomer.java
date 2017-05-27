package com.sandbox.chapter10.jcr349.services;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrii Sysoiev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IndividualCustomerValidator.class)
@Documented
public @interface CheckIndividualCustomer {

    String message() default "Individual customer should have gender and last name defined";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
