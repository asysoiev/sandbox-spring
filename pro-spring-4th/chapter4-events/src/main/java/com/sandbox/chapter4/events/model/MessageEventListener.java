package com.sandbox.chapter4.events.model;

import org.springframework.context.ApplicationListener;

/**
 * @author Andrii Sysoiev
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("Received: " + event.getMsg());
    }
}
