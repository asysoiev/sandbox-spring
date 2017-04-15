package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import com.sandbox.chapter6.jdbc.model.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrii on 18.04.17.
 */
public class SelectAllContacts extends MappingSqlQuery<Contact> {

    public static final String QUERY = "SELECT * FROM contact";

    public SelectAllContacts(DataSource ds) {
        super(ds, QUERY);
    }

    @Override
    protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ContactMapper().mapRow(rs, rowNum);
    }
}
