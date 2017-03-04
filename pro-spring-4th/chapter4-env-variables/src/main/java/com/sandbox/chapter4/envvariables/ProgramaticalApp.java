package com.sandbox.chapter4.envvariables;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrii Sysoiev
 */
public class ProgramaticalApp {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();

        ConfigurableEnvironment environment = ctx.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> props = new HashMap<>();
        props.put("java_home", "test");
        //doesn't override system
//        propertySources.addLast(new MapPropertySource("sandbox", props));
        //overrides system
        propertySources.addFirst(new MapPropertySource("sandbox", props));

        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getenv("java_home"));

        System.out.println(environment.getProperty("user.home"));
        System.out.println(environment.getProperty("java_home"));
    }

}
