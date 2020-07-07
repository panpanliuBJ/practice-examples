package com.finley.studydemo.sync;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 当有垃圾回收时，弱引用指向的对象会被回收
 *
 * @Author: liupanpan
 * @Date: 2020/4/19
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class WeakReferenceDemo {

    public static void main(String[] args) {

        WeakReference<T> weakReference = new WeakReference<>(new T());

        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

    }

    static class T {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize");
        }
    }

}
