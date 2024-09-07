package de.ait.shop42.security.sec_services;

import de.ait.shop42.security.AuthInfo;
import de.ait.shop42.security.accounting.role.entity.Role;
import de.ait.shop42.security.accounting.role.repository.RoleRepository;
import de.ait.shop42.security.accounting.role.service.RoleService;
import de.ait.shop42.security.accounting.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


@Service
public class TokenService {
    private SecretKey accessKey;
    private SecretKey refreshKey;
    private RoleService roleService;

    @Value("${access.token.days}")
    @Setter
    private int accessTokenDays;

    @Value("${refresh.token.days}")
    @Setter
    private int refreshTokenDays;

    public TokenService(@Value("${key.access}")String accessSecret,
                        @Value("${key.refresh}")String refreshSecret,
                        @Autowired RoleService roleService) {
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecret));
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecret));
        this.roleService = roleService;


    }

    public String generateAccessToken(User user) {
        Date expirationDate = calcExpirationDate(accessTokenDays);

        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .claim("roles", user.getRoles())
                .claim("name", user.getUsername())
                .signWith(accessKey)
                .compact();

    }

    private String generateRefreshToken(User user) {
        Date expirationDate = calcExpirationDate(refreshTokenDays);

        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .signWith(refreshKey)
                .compact();
    }

    private Date calcExpirationDate(int days) {
        LocalDateTime current = LocalDateTime.now();
        Instant instant = current.plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        return Date.from(instant);
    }

    public boolean validateAccessToken(String token) {
        return validateToken(token, accessKey);
    }

    public boolean validateRefreshToken(String token) {
        return validateToken(token, refreshKey);
    }

    private boolean validateToken(String token, SecretKey key) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch(Exception e) {
            return false;
        }
    }
    //6d5SM/khw/d4mEb4zRTrn0KVwz79LmUKOg0R1v/0lVI=   - access
    //DL96n5CqGIKlxg9LEH/GsyCzwoTlEmYBBbBHoKRCtmk=   - refresh

    public Claims getAccessClaims(String accessToken) {
        return getClaims(accessToken, accessKey);
    }

    public Claims getResgreshClaims(String accessToken) {
        return getClaims(accessToken, refreshKey);
    }

    private Claims getClaims(String token, SecretKey key) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public AuthInfo mapClaimsToAuthInfo(Claims claims) {
        String username = claims.getSubject();

        /*
        List [ HashMap ["authority", "ROLE_ADMIN"],  HashMap ["authority", "ROLE_USER"]  ]
         */

        List<LinkedHashMap<String, String>> rolesList
                = (List<LinkedHashMap<String, String>>) claims.get("roles");

        Set<Role> roles = new HashSet<>();

        for (var entry: rolesList) {
            String roleTitle = entry.get("authority");
            Role role = roleService.getRoleByTitle(roleTitle);
            if (role != null) {
                roles.add(role);
            }
        }

        return new AuthInfo(username, roles);

    }







}
