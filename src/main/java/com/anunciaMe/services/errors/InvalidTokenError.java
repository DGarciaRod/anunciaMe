package com.anunciaMe.services.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Invalid Token")

public class InvalidTokenError extends RuntimeException {

}
