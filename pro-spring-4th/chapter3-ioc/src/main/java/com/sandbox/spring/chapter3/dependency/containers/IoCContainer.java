package com.sandbox.spring.chapter3.dependency.containers;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;

/**
 * @author Andrii Sysoiev
 */
public interface IoCContainer {

    MessageRenderer getRenderer();

}
