package com.sandbox.spring.chapter3.dependency.containers;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;

/**
 * Kind of IoC implementation.
 * Dependency injection.
 * Constructor dependency injection IoC.
 *
 * @author Andrii Sysoiev
 */
public class ConstructorContainer implements IoCContainer {
    @Override
    public MessageRenderer getRenderer() {
        return null;
    }
}
