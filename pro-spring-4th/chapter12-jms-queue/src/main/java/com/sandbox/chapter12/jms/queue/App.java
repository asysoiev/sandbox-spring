package com.sandbox.chapter12.jms.queue;

import com.sandbox.chapter12.jms.queue.producer.MessageSender;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by andrii on 28.06.17.
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/jms-sender-app-context.xml",
                "classpath:META-INF/spring/jms-listener-app-context.xml");
        ctx.refresh();
        MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
        for (int i = 0; i < 10; i++) {
            messageSender.sendMessage("Test message: " + i);
        }
    }

}
