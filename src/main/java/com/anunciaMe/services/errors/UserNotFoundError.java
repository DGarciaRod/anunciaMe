package com.anunciaMe.services.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User Not Found")

public class UserNotFoundError extends RuntimeException {

}
