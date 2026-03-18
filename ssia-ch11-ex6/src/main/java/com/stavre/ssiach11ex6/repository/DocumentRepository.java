package com.stavre.ssiach11ex6.repository;

import com.stavre.ssiach11ex6.dto.Document;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DocumentRepository {
    private Map<String, Document> documents = new HashMap<>();

    private void populateDocuments() {
        documents.putAll(Map.of(
                "abc123", new Document("natalie"),
                "qwe123", new Document("natalie"),
                "asd555", new Document("emma")
        ));
    }


    public Document findDocument(String code) {
        if (documents.isEmpty()) {
            populateDocuments();
        }
        return documents.get(code);
    }

    public void saveDocument(String documentId, Document document) {
        if (documents.isEmpty()) {
            populateDocuments();
        }
        documents.put(documentId, document);
    }
}
