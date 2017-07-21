package com.sandbox.chapter12.rest.auth.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;

/**
 * Created by andrii on 21.07.17.
 */
public class CustomCredentialsProvider extends BasicCredentialsProvider {

    public void setCredentials(Credentials credentials) {
        this.setCredentials(AuthScope.ANY, credentials);
    }

}
