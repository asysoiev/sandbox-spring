package com.sandbox.spring.chapter2.helloworld;

import com.sandbox.spring.chapter2.helloworld.services.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class HelloWorldSpringDI {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

        MessageRenderer renderer = applicationContext.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }

}
