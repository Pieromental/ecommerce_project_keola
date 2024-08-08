package com.keola.ecommerce_backend.service;

import com.keola.ecommerce_backend.models.AuditLog;
import com.keola.ecommerce_backend.models.ErrorLog;
import com.keola.ecommerce_backend.repository.AuditLogRepository;
import com.keola.ecommerce_backend.repository.ErrorLogRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LogService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public Mono<ErrorLog> logError(Map<String, Object> errorDetails) {
        ErrorLog errorLog = new ErrorLog(
                (int) errorDetails.get("code"),
                (String) errorDetails.get("title"),
                (String) errorDetails.get("message"),
                (String) errorDetails.get("errorMessage"),
                (String) errorDetails.get("functionName"),
                (String) errorDetails.get("originError")
        );
    
        return errorLogRepository.save(errorLog);
    }

    public Mono<AuditLog> logAudit(String action, String user, Map<String, Object> details) {
        AuditLog auditLog = new AuditLog(action, user, details);
        System.out.println("Audit details: " + auditLog); // Imprimir los detalles del log de auditoría
        return auditLogRepository.save(auditLog);
    }
}