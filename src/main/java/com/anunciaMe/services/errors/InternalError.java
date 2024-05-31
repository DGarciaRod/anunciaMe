package com.anunciaMe.services.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Internal error")
public class InternalError extends ServiceError{
    @Override
    public String getCode() {
        return "internalError";
    }

    @Override
    public String getMsg() {
        return "Internal error";
    }
}
