package org.gateway.core.session;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class GatewayServer {
    private final static EventLoopGroup boss = new NioEventLoopGroup();
    private final static EventLoopGroup worker = new NioEventLoopGroup(2);
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap().
                group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new GateWayInitializer());
        ChannelFuture channelFuture = bootstrap.bind();
        Channel channel = channelFuture.channel();

    }
}
