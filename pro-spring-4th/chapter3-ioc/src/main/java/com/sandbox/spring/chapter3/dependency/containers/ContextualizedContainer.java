package com.sandbox.spring.chapter3.dependency.containers;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;

/**
 * Kind of IoC implementation.
 * Dependency lookup.
 * Contextualized dependency lookup IoC.
 *
 * @author Andrii Sysoiev
 */
public class ContextualizedContainer implements IoCContainer {
    @Override
    public MessageRenderer getRenderer() {
        return null;
    }
}
