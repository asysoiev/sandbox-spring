package com.sandbox.chapter4.events.model;

import org.springframework.context.ApplicationEvent;

/**
 * @author Andrii Sysoiev
 */
public class MessageEvent extends ApplicationEvent {

    private final String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
