package org.gateway.core.session;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public abstract class DefaultGateWayHandler<T> extends SimpleChannelInboundHandler<T> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, T o) throws Exception {
        processSession(channelHandlerContext,o);
    }

    protected abstract void processSession(ChannelHandlerContext ctx,T t);
}
