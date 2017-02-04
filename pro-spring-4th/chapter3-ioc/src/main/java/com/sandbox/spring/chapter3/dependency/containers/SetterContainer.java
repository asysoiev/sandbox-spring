package com.sandbox.spring.chapter3.dependency.containers;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;

/**
 * Kind of IoC implementation.
 * Dependency injection.
 * Setter dependency injection IoC.
 *
 * @author Andrii Sysoiev
 */
public class SetterContainer implements IoCContainer {
    @Override
    public MessageRenderer getRenderer() {
        return null;
    }
}
