package com.sandbox.chapter12.jms.queue.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by andrii on 28.06.17.
 */
public class SimpleMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.info("Received message: " + textMessage.getText());
        } catch (JMSException e) {
            logger.info("Error: " + e.getMessage());
        }
    }
}
