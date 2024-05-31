package com.anunciaMe.api.errorHandling;

import java.util.HashMap;
import java.util.List;

public class ErrorResponseModel {

    public String code;
    public String msg;

    public List<HashMap<String, String>> errorList;


    public ErrorResponseModel(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public ErrorResponseModel(String code, String msg, List<HashMap<String, String>> errorList) {
        this.code = code;
        this.msg = msg;
        this.errorList = errorList;
    }

    public ErrorResponseModel(String code, List<HashMap<String, String>> errorList) {
        this.code = code;
        this.errorList = errorList;
    }
}