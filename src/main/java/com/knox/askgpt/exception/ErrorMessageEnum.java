package com.knox.askgpt.exception;

import lombok.Getter;

@Getter
public enum ErrorMessageEnum {

    INVALID_CUST_ID("400", "ERR_MPL_00251", "Please enter valid Customer ID");
    private final String httpCode;

    private final String code;

    private final String message;

    ErrorMessageEnum(String httpCode, String code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return httpCode + ": " + code + ": " + message;
    }
}
