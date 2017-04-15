package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import com.sandbox.chapter6.jdbc.model.Contact;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by andrii on 18.04.17.
 */
public class SelectContactByFirstName extends MappingSqlQuery<Contact> {

    public static final String QUERY = "SELECT * FROM contact WHERE first_name = :first_name";

    public SelectContactByFirstName(DataSource ds) {
        super(ds, QUERY);
        declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }

    @Override
    protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ContactMapper().mapRow(rs, rowNum);
    }
}
