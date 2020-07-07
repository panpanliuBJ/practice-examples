package com.finley.studydemo.nio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.commons.io.IOUtils;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/5/4
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class FileChannelDemo {

    public static void main(String[] args) throws IOException {
        String fileName = "input.file";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);
        String message = "Knowledge is Power";
        System.out.println(message.length());
        IOUtils.write(message, fileWriter);
        fileWriter.close();

        RandomAccessFile srcRandomAccessFile = new RandomAccessFile(fileName, "r");

        FileChannel srcChannel = srcRandomAccessFile.getChannel();

        ByteBuffer inByteBuffer = ByteBuffer.allocate(10);
        srcChannel.read(inByteBuffer);
        System.out.println(
            "position:" + inByteBuffer.position() + " limit:" + inByteBuffer.limit() + " capacity:" + inByteBuffer
                .capacity());
        System.out.println(new String(inByteBuffer.array()));

        String destFileName = "output.file";
        File destFile = new File(destFileName);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        RandomAccessFile destRandomAccessFile = new RandomAccessFile(destFileName, "rw");
        FileChannel destChannel = destRandomAccessFile.getChannel();
        long size = srcChannel.size();
        System.out.println("input access file channel size " + srcChannel.size());
//        destChannel.transferFrom(srcChannel, 0, size);

        inByteBuffer.flip();
        while (inByteBuffer.hasRemaining()) {
            System.out.println("write to destChannel from ByteBuffer.");
            destChannel.write(inByteBuffer);
        }

        destChannel.close();
        srcChannel.close();

        srcRandomAccessFile.close();
        destRandomAccessFile.close();

    }


}
