package com.sandbox.chapter6.jdbc.services.springjdbc.utils;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by andrii on 18.04.17.
 */
public class InsertDetail extends BatchSqlUpdate {

    public static final String QUERY = "INSERT INTO contact_tel_detail(contact_id, tel_type, tel_number) VALUES (:contact_id, :tel_type, :tel_number)";
    public static final int BATCH_SIZE = 2;

    public InsertDetail(DataSource ds) {
        super(ds, QUERY);

        declareParameter(new SqlParameter("contact_id", Types.INTEGER));
        declareParameter(new SqlParameter("tel_type", Types.VARCHAR));
        declareParameter(new SqlParameter("tel_number", Types.VARCHAR));

        setBatchSize(BATCH_SIZE);
    }
}
