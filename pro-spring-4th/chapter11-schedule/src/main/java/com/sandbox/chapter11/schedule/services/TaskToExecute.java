package com.sandbox.chapter11.schedule.services;

import org.springframework.core.task.TaskExecutor;

/**
 * Created by andrii on 10.06.17.
 */
public class TaskToExecute {

    private TaskExecutor taskExecutor;

    public void executeTask() {
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello from thread: "
                            + Thread.currentThread().getName());
                }
            });
        }
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

}
