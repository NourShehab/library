package edu.guc.library.security;


import edu.guc.library.domain.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.text.MessageFormat.format;

    @Component
    @RequiredArgsConstructor
    @Slf4j
    public class JwtTokenUtil {

        private final String jwtSecret = "zdtlD3JK56m6wTTgsNFhqzjqP";
        private final String jwtIssuer = "edu.guc.library";

       // private final Logger logger;

        public String generateAccessToken(User user) {
            return Jwts.builder()
                    .setSubject(format("%s", user.getEmail()))
                    .setIssuer(jwtIssuer)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        }

        public String getUserId(String token) {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject().split(",")[0];
        }

        public String getUsername(String token) {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject().split(",")[1];
        }

        public Date getExpirationDate(String token) {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getExpiration();
        }

        public boolean validate(String token) {
            try {
                Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
                return true;
            } catch (SignatureException ex) {
                log.error("Invalid JWT signature - {}", ex.getMessage());
            } catch (MalformedJwtException ex) {
                log.error("Invalid JWT token - {}", ex.getMessage());
            } catch (UnsupportedJwtException ex) {
                log.error("Unsupported JWT token - {}", ex.getMessage());
            } catch (IllegalArgumentException ex) {
                log.error("JWT claims string is empty - {}", ex.getMessage());
            }
            return false;
        }

    }

