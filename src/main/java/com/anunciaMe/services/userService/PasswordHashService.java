package com.anunciaMe.services.userService;

public interface PasswordHashService {
    public String PassToHash(String pass);
    public boolean CompareHashToPass(String hash, String pass);
}
