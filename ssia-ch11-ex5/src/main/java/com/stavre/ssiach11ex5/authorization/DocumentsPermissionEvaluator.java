package com.stavre.ssiach11ex5.authorization;

import com.stavre.ssiach11ex5.dto.Document;
import com.stavre.ssiach11ex5.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class DocumentsPermissionEvaluator implements PermissionEvaluator {

    private final DocumentRepository documentRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        String code = (String) targetId;
        Document document = documentRepository.findDocument(code);
        String p = (String) permission;

        boolean admin = authentication
                .getAuthorities()
                .stream()
                .anyMatch(a -> Objects.equals(a.getAuthority(), "ROLE_admin"));

        return admin || document.owner().equals(authentication.getName());
    }
}
