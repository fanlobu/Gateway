package org.gateway.core.mapping;

import org.gateway.core.session.GateWaySession;
import org.springframework.cglib.proxy.Enhancer;

import java.util.concurrent.ConcurrentHashMap;

public class GenericServiceProxyFactory {

    public GenericServiceProxyFactory(String uri){

    }

    private static ConcurrentHashMap<String,IGenericService> mapperServices = new ConcurrentHashMap<>();

    public static IGenericService newInstance(String uri, GateWaySession gatewaySession){

        return mapperServices.computeIfAbsent(uri,s -> {
            HttpStatement statement = gatewaySession.getConfiguration().getHttpStatement(uri);
            MapperServiceMethodServiceProxy methodServiceProxy = new MapperServiceMethodServiceProxy();


            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass();
            enhancer.setInterfaces();
            enhancer.setCallback();
            return enhancer.create();
        });
    }
}
