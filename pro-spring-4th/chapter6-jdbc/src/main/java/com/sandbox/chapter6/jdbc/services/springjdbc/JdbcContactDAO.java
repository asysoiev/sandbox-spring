package com.sandbox.chapter6.jdbc.services.springjdbc;

import com.sandbox.chapter6.jdbc.model.Contact;
import com.sandbox.chapter6.jdbc.model.ContactTelDetail;
import com.sandbox.chapter6.jdbc.services.ContactDAO;
import com.sandbox.chapter6.jdbc.services.springjdbc.utils.*;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrii on 17.04.17.
 */
public class JdbcContactDAO implements ContactDAO, InitializingBean {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Contact> findAll() {
        SelectAllContacts selectAllContacts = new SelectAllContacts(dataSource);
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findAllWithDetails() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT c.id AS contact_id, c.first_name, c.last_name, c.birth_date, " +
                "d.id AS tel_detail_id, d.contact_id, d.tel_type, d.tel_number " +
                "FROM contact c " +
                "LEFT JOIN contact_tel_detail d ON d.contact_id = c.id";
        return jdbcTemplate.query(sql, new ContactResultExtractor());
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> params = new HashMap<>();
        params.put("first_name", firstName);

        SelectContactByFirstName sql = new SelectContactByFirstName(dataSource);
        return sql.executeByNamedParam(params);
    }

    @Override
    public String findFirstNameById(long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject(
                "SELECT first_name FROM contact WHERE id =?",
                new Object[]{id},
                String.class
        );
    }

    @Override
    public String findLastNameById(long id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        HashMap<String, Object> params = new HashMap<>();
        params.put("contactId", id);
        return jdbcTemplate.queryForObject(
                "SELECT last_name FROM contact WHERE id = :contactId",
                params,
                String.class
        );
    }

    @Override
    public void insert(Contact contact) {
        Map<String, Object> params = new HashMap<>();
        params.put("first_name", contact.getFirstName());
        params.put("last_name", contact.getLastName());
        params.put("birth_date", contact.getBirthDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        InsertContact insertContact = new InsertContact(dataSource);
        insertContact.updateByNamedParam(params, keyHolder);

        contact.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void insertContactWithDetail(Contact contact) {
        insert(contact);

        InsertDetail insertDetail = new InsertDetail(dataSource);
        for (ContactTelDetail detail : contact.getTelDetails()) {
            Map<String, Object> params = new HashMap<>();
            params.put("contact_id", contact.getId());
            params.put("tel_type", detail.getTelType());
            params.put("tel_number", detail.getTelNumber());
            insertDetail.updateByNamedParam(params);
        }
        insertDetail.flush();
    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> params = new HashMap<>();
        params.put("contact_id", contact.getId());
        params.put("first_name", contact.getFirstName());
        params.put("last_name", contact.getLastName());
        params.put("birth_date", contact.getBirthDate());

        UpdateContact updateContact = new UpdateContact(dataSource);
        updateContact.updateByNamedParam(params);
    }

    @Override
    public void delete(long contactId) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        HashMap<String, Object> params = new HashMap<>();
        params.put("contactId", contactId);
        jdbcTemplate.update(
                "DELETE FROM CONTACT_TEL_DETAIL WHERE CONTACT_ID = :contactId",
                params
        );
        jdbcTemplate.update(
                "DELETE FROM contact WHERE id = :contactId",
                params
        );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
    }
}
