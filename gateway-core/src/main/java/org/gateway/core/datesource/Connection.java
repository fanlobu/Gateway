package org.gateway.core.datesource;

public interface Connection {
    Object execute(String method, String[] parameterTypes, String[] parameterNames, Object[] args);
}
