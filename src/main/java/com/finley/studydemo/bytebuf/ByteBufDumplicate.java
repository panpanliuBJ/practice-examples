package com.finley.studydemo.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import java.util.Arrays;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/5/9
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class ByteBufDumplicate {

    public static void main(String[] args) {

        ByteBuf buffer = Unpooled.buffer(10);
        buffer.writeBytes(new byte[]{1, 2, 3});
        

        ByteBuf duplicateBuf = buffer.duplicate();

        //copy buffer
        ByteBuf copy = buffer.copy();

        System.out.println(duplicateBuf.toString());
        System.out.println(Arrays.toString(duplicateBuf.array()));

        //在往原来buffer 写数据后，观察duplicate 出来的buf 数据
        buffer.writeByte(4);
        System.out.println(duplicateBuf.toString());
        System.out.println(Arrays.toString(duplicateBuf.array()));

        ByteBuf slice = buffer.slice(0, 1);
        System.out.println("创建 slice buffer，slice buffer对象："+ slice.toString());
        System.out.println("创建slice，slice buffer的数据"+ Arrays.toString(slice.array()) + "\n\n");

        slice.setByte(0, 100);

        System.out.println("修改slice数据后，slice buffer对象："+ slice.toString());
        System.out.println("修改slice数据后，slice buffer的数据"+ Arrays.toString(slice.array()));

        System.out.println("修改slice数据后，原有 buffer对象："+ buffer.toString());
        System.out.println("修改slice数据后，原有 buffer的数据"+ Arrays.toString(buffer.array()));


        //copy buffer 与原有buffer 相关不影响
        System.out.println("修改slice数据后，copy buffer对象："+ copy.toString());
        System.out.println("修改slice数据后，copy buffer的数据"+ Arrays.toString(copy.array()));

        //从copy 对象中读取一个short，即bytes [1,2],二进制为：0000 0001 0000 0010

        int anInt = copy.getShort(0);
        System.out.println(anInt);         //258

        System.out.println("copy ByteBuffer 引用计数:" + copy.refCnt());


    }


}
