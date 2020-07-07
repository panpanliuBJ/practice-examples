package com.finley.studydemo.sync;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/4/22
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class AtomicIntegerDemo {

    private static volatile int inc = 0;

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];
        for (int j = 0; j < threadCount; ++j) {
            threads[j] = new Thread(() -> {
                for (int i = 0; i < 10000; ++i) {
                    inc++;
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
//            thread.join();
        }

//        while (Thread.activeCount() > 1) {
//            System.out.println(Thread.activeCount());
//            Thread.yield();
//        }

        System.out.println(Thread.activeCount());
        System.out.println(inc);

    }

}
