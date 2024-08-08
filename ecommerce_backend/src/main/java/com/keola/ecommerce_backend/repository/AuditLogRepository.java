package com.keola.ecommerce_backend.repository;

import com.keola.ecommerce_backend.models.AuditLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AuditLogRepository extends ReactiveMongoRepository<AuditLog, String> {
}