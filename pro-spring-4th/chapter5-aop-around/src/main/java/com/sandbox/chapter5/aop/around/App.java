package com.sandbox.chapter5.aop.around;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        WorkerBean workerBean = getWorkerBean();
        workerBean.doSomeWork(10000000);
    }

    private static WorkerBean getWorkerBean() {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new WorkerBean());
        pf.addAdvice(new ProfilereAdvice());
        return (WorkerBean) pf.getProxy();
    }

}
