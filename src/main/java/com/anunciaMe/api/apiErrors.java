package com.anunciaMe.api;

import org.springframework.http.ResponseEntity;

public class apiErrors {
    public static ResponseEntity InvalidLogin(){
        return ResponseEntity
                .status(400)
                .body("Invalid login!");
    }

    public static ResponseEntity InvalidToken(){
        return ResponseEntity
                .status(400)
                .body("Invalid token!");
    }

    public static ResponseEntity UserNotFound(){
        return ResponseEntity
                .status(400)
                .body("User not found!");
    }

    public static ResponseEntity InternalError(){
        return ResponseEntity
                .status(400)
                .body("User not found!");
    }
}
