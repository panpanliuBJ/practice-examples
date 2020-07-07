package com.finley.studydemo.nettyinaction;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import java.nio.ByteBuffer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/5/5
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

@Slf4j
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("The message from client.", CharsetUtil.UTF_8));

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        log.info("Client Received: {}", msg.toString(CharsetUtil.UTF_8));


    }
}
