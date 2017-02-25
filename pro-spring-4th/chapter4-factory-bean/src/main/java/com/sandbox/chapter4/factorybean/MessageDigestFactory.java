package com.sandbox.chapter4.factorybean;

import org.springframework.beans.factory.FactoryBean;

import javax.annotation.PostConstruct;
import java.security.MessageDigest;

/**
 * @author Andrii Sysoiev
 */
public class MessageDigestFactory implements FactoryBean<MessageDigest> {

    private String algorithmName = "MD5";
    private MessageDigest digest;

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    @Override
    public MessageDigest getObject() throws Exception {
        return digest;
    }

    @Override
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        this.digest = MessageDigest.getInstance(algorithmName);
    }
}
