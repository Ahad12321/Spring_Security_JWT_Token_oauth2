package com.ahad.course_app.service;

import com.ahad.course_app.model.Student;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
@Service
public class JwtService {
    @Value("${security.jwt.secret}")
    private String SECRET_KEY;
    public String findEmail(String token) {
        return exportToken(token, Claims::getSubject);
    }

    private <T> T exportToken(java.lang.String token, Function<Claims,T>claimsTFunction) {
        final  Claims claims= Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build().parseClaimsJws(token).getBody();

        return claimsTFunction.apply(claims);
    }

    private Key getKey() {
        byte[]key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);

    }

    public boolean tokenControl(String jwt, UserDetails userDetails) {
        final String email=findEmail(jwt);
        return (email.equals(userDetails.getUsername()) && !exportToken(jwt,Claims::getExpiration).before(new Date()));
    }

    public String generateToken(Student student1) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(student1.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
