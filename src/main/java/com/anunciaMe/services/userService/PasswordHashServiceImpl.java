package com.anunciaMe.services.userService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;


@Component
public class PasswordHashServiceImpl implements PasswordHashService {
    @Value("${passHash.seed}")
    private Long seed;

    private PasswordEncoder encoder;

    public PasswordHashServiceImpl() {}

    @PostConstruct
    public void init() {
        this.encoder = newBcryptEncoderFromSeed(seed);
    }

    private PasswordEncoder newBcryptEncoderFromSeed(long seed){
        SecureRandom x = new SecureRandom();
        x.setSeed(seed);
        return new BCryptPasswordEncoder(8, x);
    }

    public String PassToHash(String pass){
        return this.encoder.encode(pass);
    }

    public boolean CompareHashToPass(String hash, String pass){
        return this.encoder.matches(pass, hash);
    }
}