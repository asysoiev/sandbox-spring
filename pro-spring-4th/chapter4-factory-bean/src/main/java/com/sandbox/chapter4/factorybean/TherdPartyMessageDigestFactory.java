package com.sandbox.chapter4.factorybean;

import java.security.MessageDigest;

/**
 * @author Andrii Sysoiev
 */
public class TherdPartyMessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
