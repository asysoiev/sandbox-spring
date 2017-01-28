package com.sandbox.spring.chapter2.helloworld.model;

/**
 * @author Andrii Sysoiev
 */
public class StandardMessageOutRenderer implements MessageRenderer {
    private MessageProvider provider;

    public void render() {
        if (provider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardMessageOutRenderer.class.getName());
        } else {
            System.out.println(provider.getMessage());
        }
    }

    public MessageProvider getMessageProvider() {
        return this.provider;
    }

    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }
}
