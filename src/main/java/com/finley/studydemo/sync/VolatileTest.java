package com.finley.studydemo.sync;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/4/19
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class VolatileTest {

    public static final long TIMES = 1000_0000L;
    static T[] ts = new T[2];

    static {
        ts[0] = new T();
        ts[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (long i = 0; i < TIMES; i++) {
                ts[0].a = i;
            }
        });

        Thread other = new Thread(() -> {
            for (long i = 0; i < TIMES; i++) {
                ts[1].a = i;
            }
        });

        long startTime = System.currentTimeMillis();

        one.start();
        other.start();
        one.join();
        other.join();

        System.out.println("cost:" + (System.currentTimeMillis() - startTime));

    }

    static class T {

        private volatile long a;
    }

}
