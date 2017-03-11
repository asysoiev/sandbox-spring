package com.sandbox.chapter5.aop.after;

import java.util.Random;

/**
 * @author Andrii Sysoiev
 */
public class KeyGenerator {

    protected static final long WEAK_KEY = 0xFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0xACDF03F590AE56L;

    private final Random random;

    public KeyGenerator() {
        random = new Random();
    }

    public long getKey() {
        int i = random.nextInt(3);
        if (i == 1) {
            return WEAK_KEY;
        } else {
            return STRONG_KEY;
        }
    }
}
