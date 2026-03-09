package com.stavre.ssiach9ex4.repository;

import com.stavre.ssiach9ex4.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findTokenByIdentifier(String identifier);

    Token save(Token token);
}

