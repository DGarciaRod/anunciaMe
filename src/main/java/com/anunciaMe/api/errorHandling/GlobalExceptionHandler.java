package com.anunciaMe.api.errorHandling;

import com.anunciaMe.services.errors.ServiceError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) throws Exception {
        return ResponseEntity.badRequest()
                .body(new ErrorResponseModel("VALIDATION", processErrors(e)));
    }
    private List<HashMap<String, String>> processErrors(MethodArgumentNotValidException e) {
        List<HashMap<String, String>> validationErrorModels = new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("code", fieldError.getCode());
            map.put("field", fieldError.getField());
            map.put("details", fieldError.getDefaultMessage());
            validationErrorModels.add(map);
        }
        return validationErrorModels;
    }

    @ExceptionHandler(value = ServiceError.class)
    public ResponseEntity<?> defaultErrorHandler(HttpServletRequest req, ServiceError e) throws Exception {
        return ResponseEntity.badRequest().body(new ErrorResponseModel(e.getCode(), e.getMsg()));
    }
}