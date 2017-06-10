package com.sandbox.chapter11.schedule.services;

import java.util.concurrent.Future;

/**
 * Created by andrii on 10.06.17.
 */
public interface AsyncService {
    void asyncTask();

    Future<String> asyncWithReturn(String name);
}
