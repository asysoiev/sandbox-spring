package com.sandbox.chapter4.events;

import com.sandbox.chapter4.events.model.Publisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");

        Publisher publisher = (Publisher) context.getBean("publisher");
        publisher.publsih("Hello world");
        publisher.publsih("The quick brown fox jumped over the lazy dog");
    }

}
