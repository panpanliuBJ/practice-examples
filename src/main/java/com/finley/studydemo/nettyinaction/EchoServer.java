package com.finley.studydemo.nettyinaction;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import lombok.extern.slf4j.Slf4j;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/5/5
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

@Slf4j
public class EchoServer {

    private int port;

    public EchoServer(int port) {

        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;

        EchoServer echoServer = new EchoServer(port);

        echoServer.start();
    }

    private void start() throws InterruptedException {

        EchoServerHandler serverHandler = new EchoServerHandler();
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        log.info("init channel |threadName:{}|channel:{}",Thread.currentThread().getName(), ch);
                        ch.pipeline().addLast(serverHandler);
                    }
                });

            ChannelFuture future = serverBootstrap.bind().sync();
            log.info(EchoServer.class.getName() +
                " started and listening for connections on " + future.channel().localAddress());
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("server shutdown gracefully");
            group.shutdownGracefully().sync();

        }

    }

}
