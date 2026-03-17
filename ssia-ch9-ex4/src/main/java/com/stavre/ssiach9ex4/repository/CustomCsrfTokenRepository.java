package com.stavre.ssiach9ex4.repository;

import com.stavre.ssiach9ex4.entity.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CustomCsrfTokenRepository implements CsrfTokenRepository {

    public static final String X_IDENTIFIER = "X-IDENTIFIER";
    private final JpaTokenRepository jpaTokenRepository;

    public CustomCsrfTokenRepository(JpaTokenRepository jpaTokenRepository) {
        this.jpaTokenRepository = jpaTokenRepository;
    }

    @Override
    public @NonNull CsrfToken generateToken(@NonNull HttpServletRequest request) {
        log.info("generate token");

        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(@Nullable CsrfToken csrfToken, HttpServletRequest request, @NonNull HttpServletResponse response) {
        log.info("Save token");

        String identifier = request.getHeader(X_IDENTIFIER);
        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

        if (existingToken.isPresent()) {
            Token token = existingToken.get();
            token.setToken(csrfToken.getToken());

        } else {
            Token token = new Token();
            token.setToken(csrfToken.getToken());
            token.setIdentifier(identifier);
            jpaTokenRepository.save(token);
        }


    }

    @Override
    public @Nullable CsrfToken loadToken(HttpServletRequest request) {
        log.info("load token");

        String identifier = request.getHeader(X_IDENTIFIER);
        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

        if (existingToken.isEmpty()) {
            return null;
        }

        Token token = existingToken.get();
        CsrfToken csrfToken = new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken());
//        request.setAttribute("X-CSRF-TOKEN", csrfToken);

        return csrfToken;
    }
}
