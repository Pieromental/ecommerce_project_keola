package com.keola.ecommerce_backend.repository;

import com.keola.ecommerce_backend.models.ErrorLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ErrorLogRepository extends ReactiveMongoRepository<ErrorLog, String> {
}