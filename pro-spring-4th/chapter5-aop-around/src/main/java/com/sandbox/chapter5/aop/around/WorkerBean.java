package com.sandbox.chapter5.aop.around;

/**
 * @author Andrii Sysoiev
 */
public class WorkerBean {

    public void doSomeWork(int times) {
        for (int i = 0; i < times; i++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }

}
