package org.gateway.core.session;

import org.gateway.core.session.handler.DefaultGateWaySession;

public class DefaultGateWaySessionFactory implements GateWaySessionFactory{
    @Override
    public GateWaySession openSession(String uri) {
        // 如何创建会话
        // 1.不同来源请求应该抽象成
        return null;
    }
}
