package model;

import com.sandbox.spring.chapter3.dependency.services.MessageProvider;

/**
 * @author Andrii Sysoiev
 */
public class PropertyMessageProvider implements MessageProvider {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
