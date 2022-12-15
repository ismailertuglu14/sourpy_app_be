package org.sourpy.ecomapp.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private final static String accessToken = "7835BD2A4BE64AF8A2E24CE81433738C8C8C06179517843C4FBB162088F43A90";
    private final static Long expireTime = 60L*1000L*10080L;

    public static String createToken(Long id,String username){
        Date expirationDate = new Date(System.currentTimeMillis() + expireTime);
        Date issuedAtDate = new Date(System.currentTimeMillis());

        Map<String,Object> extra = new HashMap<>();
        extra.put("id",id);
        extra.put("username",username);

        return Jwts.builder()
                .addClaims(extra)
                .setIssuedAt(issuedAtDate)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(accessToken.getBytes()),SignatureAlgorithm.HS256)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(accessToken.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username = (String) claims.get("username");
        return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
    }
}
