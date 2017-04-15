package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by andrii on 18.04.17.
 */
public class UpdateContact extends SqlUpdate {

    public static final String QUERY = "UPDATE contact " +
            "SET first_name = :first_name, " +
            " last_name = :last_name," +
            " birth_date = :birth_date " +
            "WHERE id = :contact_id";

    public UpdateContact(DataSource ds) {
        super(ds, QUERY);
        declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        declareParameter(new SqlParameter("birth_date", Types.DATE));
        declareParameter(new SqlParameter("contact_id", Types.INTEGER));
    }
}
