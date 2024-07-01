package org.gateway.core.session;

public interface GateWaySessionFactory {
   GateWaySession openSession(String uri);
}
