package com.anunciaMe.services.errors;

public abstract class ServiceError extends Error {
    public String getCode() {
        return "";
    }

    public String getMsg() {
        return null;
    }

}
