package com.sandbox.spring.chapter3.dependency.containers;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;

/**
 * Kind of IoC implementation.
 * Dependency lookup.
 * Dependency pull IoC.
 *
 * @author Andrii Sysoiev
 */
public class PullContainer implements IoCContainer {
    @Override
    public MessageRenderer getRenderer() {
        return null;
    }
}
