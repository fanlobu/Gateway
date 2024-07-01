package org.gateway.core.session.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import org.gateway.core.mapping.IGenericService;
import org.gateway.core.session.DefaultGateWayHandler;
import org.gateway.core.session.GateWaySession;
import org.gateway.core.session.GateWaySessionFactory;

public class GateWayServerHandler extends DefaultGateWayHandler<HttpRequest> {

    private GateWaySessionFactory gateWaySessionFactory;

    public GateWayServerHandler(GateWaySessionFactory gateWaySessionFactory){
        this.gateWaySessionFactory = gateWaySessionFactory;
    }

    @Override
    protected void processSession(ChannelHandlerContext ctx, HttpRequest httpRequest) {
        // 连接建立之后，处理http请求
        // 映射rpc
        // 建立泛化对象 ，泛化调用
        String uri = httpRequest.uri();

        // 一次调用
        GateWaySession gateWaySession = gateWaySessionFactory.openSession(uri);
        // 根据以保存的映射信息（服务注册时保存的） 找到对应的调用服务
        IGenericService genericService = gateWaySession.getMappendService(uri);
        // 服务调用
        genericService.$invoke();

    }
}
