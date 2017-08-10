package com.sandbox.chapter12.jms.queue;

import com.sandbox.chapter12.jms.queue.producer.MessageSender;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by andrii on 28.06.17.
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("hornetq");
        ctx.getEnvironment().setActiveProfiles("activemq");
        ctx.load("classpath:META-INF/spring/*app-context.xml");
        ctx.refresh();
        MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
        for (int i = 0; i < 3; i++) {
            messageSender.sendMessage("Test message: " + i);
        }
    }

}
