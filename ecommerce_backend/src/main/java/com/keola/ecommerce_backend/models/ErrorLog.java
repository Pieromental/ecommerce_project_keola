package com.keola.ecommerce_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "error_logs")
public class ErrorLog {
    @Id
    private String id;
    private int code;
    private String title;
    private String message;
    private String errorMessage;
    private String functionName;
    private String originError;
    private Date timestamp;

    // Constructor con todos los campos
    public ErrorLog(int code, String title, String message, String errorMessage, String functionName,
            String originError) {
        this.code = code;
        this.title = title;
        this.message = message;
        this.errorMessage = errorMessage;
        this.functionName = functionName;
        this.originError = originError;
        this.timestamp = new Date();
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getOriginError() {
        return originError;
    }

    public void setOriginError(String originError) {
        this.originError = originError;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}