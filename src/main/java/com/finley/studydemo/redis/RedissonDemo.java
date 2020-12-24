package com.finley.studydemo.redis;

import java.util.Date;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/7/7
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class RedissonDemo {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);

        RedissonClient client = Redisson.create(config);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始 " + new Date());
            RLock redLock = client.getLock("redLock");
            System.out.println(Thread.currentThread().getName() + "准备获取锁" + new Date());
            redLock.lock();
            System.out.println(Thread.currentThread().getName() + " 拿到锁 " + new Date());

            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 模拟在做事情");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                redLock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放锁 " + new Date());
            }
        }).start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始 " + new Date());
            RLock redLock = client.getLock("redLock");
            System.out.println(Thread.currentThread().getName() + " 准备获取锁 " + new Date());
            redLock.lock();
            System.out.println(Thread.currentThread().getName() + " 拿到锁 " + new Date());

            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 模拟在做事情");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                redLock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放锁 " + new Date());
            }
        }).start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
