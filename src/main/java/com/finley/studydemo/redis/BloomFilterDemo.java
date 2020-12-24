package com.finley.studydemo.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/7/14
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class BloomFilterDemo {

    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000, 0.01);

        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));

        bloomFilter.put(1);
        bloomFilter.put(2);

        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
    }

}
