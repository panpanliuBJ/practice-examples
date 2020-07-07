package com.finley.studydemo.sync;

import java.lang.ref.WeakReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/4/19
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        /*
        ThreadLocal<CoinType> threadLocal = new ThreadLocal<CoinType>();
        threadLocal.set(new CoinType("btc"));

        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
        */



        /*ThreadLocalMap 数据结构 table[]  + entry， 并非真正的map，而是数组 */
        /*int times = 100;
        for (int i = 0; i < times; i++) {
            ThreadLocal<CoinType> coinTypeThreadLocal = new ThreadLocal<>();
            coinTypeThreadLocal.set(new CoinType("BTC_" + i));
        }

        ThreadLocal<CoinType> coinTypeThreadLocal = new ThreadLocal<>();
        coinTypeThreadLocal.set(new CoinType("BTC_" + times + 1));*/




        /*threadLocal.set("threadName:" + Thread.currentThread().getName() + "-threadLocal");

        Thread thread = new Thread(() -> {
            System.out.println(
                "Before set value. threadName:" + Thread.currentThread().getName() + " threadLocal get: " + threadLocal
                    .get());
            threadLocal.set(Thread.currentThread().getName() + "-threadLocal");

            System.out.println(
                "After set value. threadName:" + Thread.currentThread().getName() + " threadLocal get: " + threadLocal
                    .get());
        });

        thread.start();
        thread.join();

        System.out.println("threadName:" + Thread.currentThread().getName() + " threadLocal get: " + threadLocal.get());*/

        String name = "threadLocal from Main";
        threadLocal.set(name);

        threadLocal = null;
        ThreadLocal<T> tThreadLocal = new ThreadLocal<>();
        tThreadLocal.set(new T());

        WeakReference<T> tWeakReference = new WeakReference<>(new T());
        System.out.println(tWeakReference.get());
        System.gc();

        Thread.sleep(1000);
        System.out.println(tThreadLocal.get());
        System.out.println(tWeakReference.get());

    }

    static class T {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize");
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class CoinType {

        private String name;
    }

}
