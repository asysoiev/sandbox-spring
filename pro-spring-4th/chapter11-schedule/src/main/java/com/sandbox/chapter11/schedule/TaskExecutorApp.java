package com.sandbox.chapter11.schedule;

import com.sandbox.chapter11.schedule.services.TaskToExecute;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by andrii on 10.06.17.
 */
public class TaskExecutorApp {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/task-executor-app-context.xml");
        ctx.refresh();
        TaskToExecute taskToExecute = ctx.getBean(TaskToExecute.class);
        taskToExecute.executeTask();
    }

}
