package com.sandbox.chapter5.aop.proxies;

/**
 * @author Andrii Sysoiev
 */
public class SimpleBeanImpl implements SimpleBean {

    private long dummy;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
