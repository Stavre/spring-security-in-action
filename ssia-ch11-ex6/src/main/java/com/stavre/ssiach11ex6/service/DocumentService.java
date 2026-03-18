package com.stavre.ssiach11ex6.service;

import com.stavre.ssiach11ex6.dto.Document;
import com.stavre.ssiach11ex6.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public Document getDocument(String code) {
        return documentRepository.findDocument(code);
    }

    public void uploadDocument(String id, Document document) {
        documentRepository.saveDocument(id, document);
    }
}
