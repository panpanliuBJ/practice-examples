package com.finley.studydemo.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/5/9
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class ByteBufDemo {

    public static void main(String[] args) {

        ByteBuf buf = Unpooled.buffer(10);
        System.out.println("原始 ByteBuf 为:" + buf.toString());
        System.out.println("1 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //2. 写入一段内容
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        buf.writeBytes(bytes);

        System.out.println("写入的bytes:" + Arrays.toString(bytes));
        System.out.println("写入一段bytes后的 ByteBuf 为:" + buf.toString());
        System.out.println("2 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //3. 读取一段内容
        byte b1 = buf.readByte();
        byte b2 = buf.readByte();

        System.out.println("读取的bytes:" + Arrays.toString(new byte[]{b1, b2}));
        System.out.println("读取一段bytes后的 ByteBuf 为:" + buf.toString());
        System.out.println("3 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //4 将读取的内容丢弃
        buf.discardReadBytes();
        System.out.println("丢弃一段bytes后的 ByteBuf 为:" + buf.toString());
        System.out.println("4 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //5. 清空读写指针
        buf.clear();
        System.out.println("清空读写指针 ByteBuf 为:" + buf.toString());
        System.out.println("5 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //6. 再次写入一段数据
        byte[] bytes2 = {1, 2, 3, 100};
        buf.writeBytes(bytes2);
        System.out.println("再次写入的一段数据:" + Arrays.toString(bytes2));
        System.out.println("再次写入的一段数据 ByteBuf 为:" + buf.toString());
        System.out.println("6 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //7. 将buf置0
        buf.setZero(0, buf.capacity());
        System.out.println("置0后 ByteBuf 为:" + buf.toString());
        System.out.println("7 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        //8. 写入一块超量的数据
//        byte[] bytes3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        buf.writeBytes(bytes3);
//        System.out.println("超量的数据 ByteBuf 为:" + Arrays.toString(bytes3));
//        System.out.println("写入超量的数据 ByteBuf 为:" + buf.toString());
//        System.out.println("8 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");

        byte[] bytes3 = new byte[65];
        for (int i = 0; i < bytes.length; i++) {
            bytes3[i] = (byte)(i + 1);
        }
        buf.writeBytes(bytes3);
        System.out.println("超量的数据 ByteBuf 为:" + Arrays.toString(bytes3));
        System.out.println("写入超量的数据 ByteBuf 为:" + buf.toString());
        System.out.println("8 ByteBuf 为:" + Arrays.toString(buf.array()) + "\n\n");



    }


}
