package com.finley.studydemo.sync;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/4/21
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class SynchronizedDemo {

    public void syncBlock() {
        synchronized (this) {
            System.out.println("Synchronized block");
        }
    }

    public synchronized void syncMethod() {
        System.out.println("Synchronized method");
    }

}
