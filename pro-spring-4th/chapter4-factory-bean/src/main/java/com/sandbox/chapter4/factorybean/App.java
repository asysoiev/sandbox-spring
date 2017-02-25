package com.sandbox.chapter4.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext appContext = new GenericXmlApplicationContext();
        appContext.load("classpath:META-INF/spring/app-context-xml.xml");
        appContext.refresh();

        String msg = "Hello World!";

        MessageDigester digester = (MessageDigester) appContext.getBean("digester");
        digester.digest(msg);

        MessageDigestFactory factory = (MessageDigestFactory) appContext.getBean("&defaultDigest");

        try {
            MessageDigest digest = factory.getObject();
            System.out.println("Using factory in direct way");
            System.out.println("Using algorithm: " + digest.getAlgorithm());
            byte[] msgBytes = msg.getBytes();
            byte[] digestBytes = digest.digest(msgBytes);
            System.out.println(digestBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
