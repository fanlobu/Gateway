package org.gateway.core.authorization;


public interface IAuthorization {

    boolean validate(String id, String token);

}