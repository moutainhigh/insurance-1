package com.yundian.fssapi.exception;

public class FssCarException extends RuntimeException{

    private String code;

    public FssCarException(String message) {
        super(message);
    }

    public FssCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssCarException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssCarException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssCarException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
