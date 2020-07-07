package com.finley.studydemo.singleton;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/4/19
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class SingletonDemo {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                SingletonObject instance = SingletonObject.getInstance();
                System.out.println(instance.hashCode() + " var:" + instance.var);
            });
            thread.start();
//            thread.join();
        }


    }

    static class SingletonObject {

        private volatile static SingletonObject INSTANCE;

        private int var = 10;
        private SingletonObject() {


        }

        public static SingletonObject getInstance() {
            if (INSTANCE == null) {
                synchronized (SingletonDemo.class) {

                    if (INSTANCE == null) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        INSTANCE = new SingletonObject();
                    }
                }
            }
            return INSTANCE;
        }

    }


}
