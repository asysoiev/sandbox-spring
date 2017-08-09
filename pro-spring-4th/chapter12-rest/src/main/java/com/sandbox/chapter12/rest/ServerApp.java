package com.sandbox.chapter12.rest;

import com.sandbox.chapter12.rest.configs.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by andrii on 09.08.17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath*:/META-INF/spring/restful-server-app-context.xml")
@Import({SecurityConfig.class})
public class ServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class, args);
    }
}
