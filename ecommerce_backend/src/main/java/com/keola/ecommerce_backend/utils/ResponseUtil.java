package com.keola.ecommerce_backend.utils;

import com.keola.ecommerce_backend.utils.CustomResponse;
import com.keola.ecommerce_backend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseUtil {

    @Autowired
    private LogService logService;

    public <T> ResponseEntity<CustomResponse<T>> createResponse(int code, String title, String message, T data, Object otherData, String messageError, String functionName) {
        CustomResponse<T> response = new CustomResponse<>();
        response.setStatus(code == HttpStatus.OK.value());
        response.setCode(code);
        response.setData(data);
        response.setOtherData(otherData);
        response.setTitle(title);
        response.setMessage(message);
        response.setMessageError(messageError);
        response.setFunctionName(functionName);

        if (code == HttpStatus.OK.value()) {
            Map<String, Object> details = new HashMap<>();
            details.put("code", code);
            details.put("title", title);
            details.put("message", message);
            details.put("data", data);
            details.put("otherData", otherData);
            logService.logAudit(functionName, "API User", details).subscribe();
        } else {
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("code", code);
            errorDetails.put("title", title);
            errorDetails.put("message", message);
            errorDetails.put("data", data);
            errorDetails.put("otherData", otherData);
            errorDetails.put("errorMessage", messageError);
            errorDetails.put("functionName", functionName);
            errorDetails.put("originError", "backend");
            logService.logError(errorDetails).subscribe();
        }

        return new ResponseEntity<>(response, HttpStatus.valueOf(code));
    }
}