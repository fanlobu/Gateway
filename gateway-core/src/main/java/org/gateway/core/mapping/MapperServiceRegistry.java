package org.gateway.core.mapping;

import org.gateway.core.session.GateWaySession;

public interface MapperServiceRegistry {

    public IGenericService getMappenedService(String uri, GateWaySession gatewaySession);

    public boolean addMappendService(HttpStatement httpStatement);
}
