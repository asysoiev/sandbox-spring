package com.sandbox.chapter4.profiles;

import com.sandbox.chapter4.profiles.model.Food;
import com.sandbox.chapter4.profiles.model.FoodProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //VM option: -Dspring.profiles.active="kindergarten"
        ctx.getEnvironment().setActiveProfiles("kindergarten");
        ctx.load("classpath:META-INF/spring/*-context-xml.xml");
        ctx.refresh();

        FoodProvider foodProviderService = ctx.getBean("foodProviderService", FoodProvider.class);
        List<Food> lunch = foodProviderService.getLunch();
        for (Food food : lunch) {
            System.out.println(food.getName());
        }
    }

}
