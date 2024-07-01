package org.gateway.core.session.handler;

import org.gateway.core.mapping.IGenericService;

import java.util.Map;

public class DefaultGateWaySession implements org.gateway.core.session.GateWaySession {
    @Override
    public IGenericService getMappendService(String uri) {
        return null;
    }

    @Override
    public Object get(String methodName, Map<String, Object> params) {
        return null;
    }
}
