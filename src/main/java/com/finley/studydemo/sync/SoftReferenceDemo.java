package com.finley.studydemo.sync;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 当堆空间足够时，即使强制垃圾回收，也不会被回收
 * 当对空间不够时，会处理对空间回收
 *
 * @Author: liupanpan
 * @Date: 2020/4/19
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class SoftReferenceDemo {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().maxMemory());
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[10 * 1024 * 1024]);
        System.out.println(softReference.get());

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReference.get());

        byte[] bytes2 = new byte[15 * 1024 * 1024];
        System.out.println(softReference.get()); //softReference 指向对象的对象堆空间被释放


    }

}
