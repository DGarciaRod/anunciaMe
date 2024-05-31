package com.anunciaMe.services.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User already exists")

public class UserAlreadyExistis extends ServiceError {
    @Override
    public String getCode() {
        return "usrAlreadyExists";
    }

    @Override
    public String getMsg() {
        return "User already exists";
    }
}
