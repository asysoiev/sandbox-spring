package com.sandbox.chapter6.jdbc.services.plainjdbc;

import com.sandbox.chapter6.jdbc.model.Contact;
import com.sandbox.chapter6.jdbc.services.ContactDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 17.04.17.
 */
public class PlainContactDAO implements ContactDAO {

    private String driver;// = "org.h2.Driver";
    private String usr;// = "sa";
    private String pass;// = "";
    private String url;// = "jdbc:h2:tcp://localhost/~/test";

    public void setDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        this.driver = driver;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usr, pass);
    }

    private void closeConnection(Connection connection){
        if(connection == null){
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<>();

        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from CONTACT");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));
                result.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return result;
    }

    @Override
    public List<Contact> findAllWithDetails() {
        throw new NotImplementedException();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        throw new NotImplementedException();
    }

    @Override
    public String findFirstNameById(long id) {
        throw new NotImplementedException();
    }

    @Override
    public String findLastNameById(long id) {
        throw new NotImplementedException();
    }

    @Override
    public void insert(Contact contact) {
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CONTACT(FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(contact.getBirthDate().getTime()));
            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()){
                contact.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void insertContactWithDetail(Contact contact) {
        throw new NotImplementedException();
    }

    @Override
    public void update(Contact contact) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(long contactId) {
        Connection connection = null;
        try {
            connection = getConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM CONTACT WHERE ID = ?");
            statement.setLong(1, contactId);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
}
