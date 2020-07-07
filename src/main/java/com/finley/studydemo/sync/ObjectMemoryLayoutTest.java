package com.finley.studydemo.sync;

import com.finley.studydemo.sync.VolatileTest2.T;
import org.openjdk.jol.info.ClassLayout;

/**
 * Test Object Layout
 *
 * @Author: liupanpan
 * @Date: 2020/4/18
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class ObjectMemoryLayoutTest {



    public static void main(String[] args) throws InterruptedException {
        //无锁
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());


        Thread.sleep(5000);

        //偏向锁
        //00000101 00000000 00000000 00000000
        Object b = new Object();
        System.out.println(ClassLayout.parseInstance(b).toPrintable());

        //00000101 00001000 10000001 01011100
        //当前的线程将线程ID写入 mark word 中
        synchronized (b) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId());
            System.out.println(ClassLayout.parseInstance(b).toPrintable());
        }



        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());

        int[] ints = new int[2];
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
    }

}
