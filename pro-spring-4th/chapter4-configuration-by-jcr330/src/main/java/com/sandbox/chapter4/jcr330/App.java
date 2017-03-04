package com.sandbox.chapter4.jcr330;

import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }

}
