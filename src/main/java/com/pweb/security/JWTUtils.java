package com.pweb.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private static final Logger LOG= LoggerFactory.getLogger(JWTUtils.class);
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    public Boolean validateJwtToken(String token){
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        return true;
    }

}
