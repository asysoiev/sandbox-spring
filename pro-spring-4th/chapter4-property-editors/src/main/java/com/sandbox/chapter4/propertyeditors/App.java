package com.sandbox.chapter4.propertyeditors;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) throws Exception {
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("classpath:META-INF/spring/app-context-xml.xml");
        applicationContext.refresh();

        PropertyEditorBean propertyEditor = (PropertyEditorBean) applicationContext.getBean("builtInSample");
    }

}
