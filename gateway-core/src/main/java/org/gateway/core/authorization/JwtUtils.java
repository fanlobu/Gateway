package org.gateway.core.authorization;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class JwtUtils {


    public static Claims decode(String token){
        return Jwts.parser().setSigningKey("4869").parseClaimsJws(token).getBody();
    }

    String encode(String signer, long ttl, Map<String,Object> claims){
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis())).setSubject(signer).signWith(SignatureAlgorithm.HS256,"4869").setExpiration(new Date(System.currentTimeMillis()+ttl)).compact();
    }

}
