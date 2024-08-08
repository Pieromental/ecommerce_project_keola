package com.keola.ecommerce_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "audit_logs")
public class AuditLog {

    @Id
    private String id;
    private String action;
    private String user;
    private LocalDateTime timestamp;
    private Map<String, Object> details;

    public AuditLog(String action, String user, Map<String, Object> details) {
        this.action = action;
        this.user = user;
        this.timestamp = LocalDateTime.now();
        this.details = details;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "AuditLog{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", user='" + user + '\'' +
                ", timestamp=" + timestamp +
                ", details='" + details + '\'' +
                '}';
    }
}