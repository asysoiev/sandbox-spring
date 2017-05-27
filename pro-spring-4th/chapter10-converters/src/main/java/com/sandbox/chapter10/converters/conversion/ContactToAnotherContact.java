package com.sandbox.chapter10.converters.conversion;

import com.sandbox.chapter10.converters.model.AnotherContact;
import com.sandbox.chapter10.converters.model.Contact;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Andrii Sysoiev
 */
public class ContactToAnotherContact implements Converter<Contact, AnotherContact> {
    @Override
    public AnotherContact convert(Contact source) {
        AnotherContact result = new AnotherContact();
        result.setFirstName(source.getLastName());
        result.setLastName(source.getFirstName());
        result.setBirthDate(source.getBirthDate());
        result.setPersonalSite(source.getPersonalSite());
        return result;
    }
}
