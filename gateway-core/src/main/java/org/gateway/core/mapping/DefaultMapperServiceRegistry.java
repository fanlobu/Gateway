package org.gateway.core.mapping;

import org.gateway.core.session.Configuration;
import org.gateway.core.session.GateWaySession;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DefaultMapperServiceRegistry implements MapperServiceRegistry {

    private Configuration configuration;

    public DefaultMapperServiceRegistry(Configuration configuration){
        this.configuration = configuration;
    }

    private ConcurrentHashMap<String,GenericServiceProxyFactory> factoryMapperMap = new ConcurrentHashMap<>();

    @Override
    public IGenericService getMappenedService(String uri, GateWaySession gatewaySession) {

        GenericServiceProxyFactory factory = factoryMapperMap.get(uri);
        return factory.newInstance(uri,gatewaySession);
    }

    @Override
    public boolean addMappendService(HttpStatement httpStatement) {

        return factoryMapperMap.computeIfAbsent(httpStatement.getUri(), s -> {
            return new GenericServiceProxyFactory(uri);
        });
    }
}
