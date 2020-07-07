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

public class ObjectMemoryLayoutTest2 {



    public static void main(String[] args) throws InterruptedException {
        //无锁
        Object o = new Object();

        //普通对象的内存模型
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


        Thread.sleep(5000);

        //偏向锁
        //00000101 00000000 00000000 00000000
        Object b = new Object();
        System.out.println(ClassLayout.parseInstance(b).toPrintable());



        //数组的内存模型
        int[] ints = new int[2];
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
    }

}
