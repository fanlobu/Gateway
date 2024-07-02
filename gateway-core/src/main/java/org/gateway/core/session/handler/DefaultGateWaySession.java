package org.gateway.core.session.handler;

import org.gateway.core.mapping.IGenericService;
import org.gateway.core.session.Configuration;

import java.util.Map;

public class DefaultGateWaySession implements org.gateway.core.session.GateWaySession {

    private final Configuration configuration;

    public DefaultGateWaySession(Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public IGenericService getMappendService(String uri) {
        return null;
    }

    @Override
    public Object get(String methodName, Map<String, Object> params) {
        return null;
    }
}
