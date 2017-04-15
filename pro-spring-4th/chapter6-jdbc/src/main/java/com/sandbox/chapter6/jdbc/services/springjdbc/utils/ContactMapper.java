package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import com.sandbox.chapter6.jdbc.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrii on 18.04.17.
 */
public final class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact result = new Contact();
        result.setId(rs.getLong("id"));
        result.setFirstName(rs.getString("first_name"));
        result.setLastName(rs.getString("last_name"));
        result.setBirthDate(rs.getDate("birth_date"));
        return result;
    }
}
