package com.sandbox.chapter4.internationalization;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        Locale en = Locale.ENGLISH;
        Locale cz = new Locale("cz", "CZ");

        System.out.println(ctx.getMessage("msg", null, en));
        System.out.println(ctx.getMessage("msg", null, cz));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"Andrii", "Sysoiev"}, en));
    }

}
