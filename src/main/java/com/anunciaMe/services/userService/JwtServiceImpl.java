package com.anunciaMe.services.userService;

import com.anunciaMe.entities.Usuario.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long tknExpirationTime;
    

    public String generateToken(Usuario user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        return createToken(claims, user.getId());
    }

    public JwtPayload validateToken(String token)  {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(getSignKey())
                .build();
        Claims claims;
        try {
            claims = jwtParser.parseClaimsJws(token).getBody();
            JwtPayload JwtPayload = new JwtPayload(claims.get("id").toString(),
                    Long.parseLong(claims.get("iat").toString()), Long.parseLong(claims.get("exp").toString()));
            if(JwtPayload.getExpirationDate()>=JwtPayload.getCreationDate()+ tknExpirationTime)
                throw new Exception();
            return JwtPayload;
        } catch (Exception e) {
            throw new RuntimeException("Could not verify JWT token integrity!");
        }
    }

    private String createToken(Map<String, Object> claims, String userId) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tknExpirationTime))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}