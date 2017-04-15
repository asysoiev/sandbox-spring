package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by andrii on 18.04.17.
 */
public class InsertContact extends SqlUpdate {

    public static final String QUERY = "INSERT INTO contact(first_name, last_name, birth_date) VALUES (:first_name, :last_name, :birth_date)";

    public InsertContact(DataSource ds) {
        super(ds, QUERY);

        declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        declareParameter(new SqlParameter("birth_date", Types.DATE));

        setGeneratedKeysColumnNames(new String[]{"id"});
        setReturnGeneratedKeys(true);
    }
}
