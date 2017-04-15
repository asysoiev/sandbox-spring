package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import com.sandbox.chapter6.jdbc.model.Contact;
import com.sandbox.chapter6.jdbc.model.ContactTelDetail;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrii on 18.04.17.
 */
public class ContactResultExtractor implements ResultSetExtractor<List<Contact>> {
    @Override
    public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Contact> result = new HashMap<>();

        while (rs.next()) {
            long contactId = rs.getLong("contact_id");
            Contact contact = result.get(contactId);
            if (contact == null) {
                contact = new Contact();
                contact.setId(contactId);
                contact.setFirstName(rs.getString("first_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setBirthDate(rs.getDate("birth_date"));
                result.put(contactId, contact);
            }

            long telDetailId = rs.getLong("tel_detail_id");
            if (telDetailId != 0) {
                ContactTelDetail detail = new ContactTelDetail();
                detail.setId(telDetailId);
                detail.setContactId(contactId);
                detail.setTelNumber(rs.getString("tel_number"));
                detail.setTelType(rs.getString("tel_type"));
                contact.addTelDetail(detail);
            }
        }

        return new ArrayList<>(result.values());
    }
}
