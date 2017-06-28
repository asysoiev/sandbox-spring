package com.sandbox.chapter12.jms.queue.producer.v1;

import com.sandbox.chapter12.jms.queue.producer.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by andrii on 28.06.17.
 */
@Component("messageSender")
public class SimpleMessageSender implements MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(String message) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
