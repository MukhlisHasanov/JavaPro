package de.ait.shop42.security.sec_services;

import de.ait.shop42.security.accounting.user.entity.User;
import de.ait.shop42.security.sec_dto.TokenResponseDto;
import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDetailsService userService;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;

    private final Map<String, String> refreshTokenStorage = new HashMap<>();

    public TokenResponseDto login(User inboundUser) {

        String username = inboundUser.getUsername();
        User foundUser = (User) userService.loadUserByUsername(username);

        if(passwordEncoder.matches(inboundUser.getPassword(), foundUser.getPassword())) {

            String accessToken = tokenService.generateAccessToken(foundUser);
            String refreshToken = tokenService.generateAccessToken(foundUser);

            refreshTokenStorage.put(accessToken, refreshToken);
        } else {
            throw new AuthException("Invalid password");
        }

        public TokenResponseDto getNewAccessToken(String inboundRefreshToken) {
            Claims refreshClaims = tokenService.getResgreshClaims(inboundRefreshToken);
            String username = refreshClaims.getSubject();

            String savedRefreshToken = refreshTokenStorage.get(username);

            if(savedRefreshToken != null && savedRefreshToken.equals(inboundRefreshToken)) {
                User foundUser = (User).userService.loadUserByUsername(username);
                String accessToken = tokenService.generateAccessToken(foundUser);
                return new TokenResponseDto(accessToken, inboundRefreshToken);
            } else {
                return new TokenResponseDto(null, null);
            }
        }

    }
}
