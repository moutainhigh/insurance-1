package com.yundian.fssapi.exception;

public class FssUserException extends RuntimeException{

    private String code;

    public FssUserException(String message) {
        super(message);
    }

    public FssUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssUserException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssUserException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssUserException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
