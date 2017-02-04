package com.sandbox.spring.chapter3.dependency.containers;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Andrii Sysoiev
 */
public class IocContainerTest {

    @Test
    public void testPullContainer() throws Exception {
        IoCContainer container = new PullContainer();
        MessageRenderer renderer = container.getRenderer();
        assertNotNull(renderer);
        assertNotNull(renderer.getMessageProvider());
    }

    @Test
    public void testContextualizedContainer() throws Exception {
        IoCContainer container = new ContextualizedContainer();
        MessageRenderer renderer = container.getRenderer();
        assertNotNull(renderer);
        assertNotNull(renderer.getMessageProvider());
    }

    @Test
    public void testConstructorContainer() throws Exception {
        IoCContainer container = new ConstructorContainer();
        MessageRenderer renderer = container.getRenderer();
        assertNotNull(renderer);
        assertNotNull(renderer.getMessageProvider());
    }

    @Test
    public void testSetterContainer() throws Exception {
        IoCContainer container = new SetterContainer();
        MessageRenderer renderer = container.getRenderer();
        assertNotNull(renderer);
        assertNotNull(renderer.getMessageProvider());
    }
}