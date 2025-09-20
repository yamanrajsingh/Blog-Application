package com.yrs.blog.blogappapis.config.securityConfig;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtConfig {
    private static final String JWT_SECRET_KEY = "YamanRajSingh_Blog_Application_07";
    private final Key SECRET_KEY = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes());

    public String getJwtToken(String username) {
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 300))
                .signWith(SECRET_KEY).compact();
        System.out.println("Generated token:" + token);
        return token;
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token Expired: " + e.getMessage());
            return false;

        } catch (SignatureException e) {
            System.out.println("Invalid Signature Token: " + e.getMessage());
            return false;
        } catch (JwtException e) {
            System.out.println("JWT Exception : " + e.getMessage());
            return false;
        }

    }
}

