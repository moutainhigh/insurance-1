package com.yundian.fssapi.exception;

public class FssAdminUserException extends RuntimeException{

    private String code;

    public FssAdminUserException(String message) {
        super(message);
    }

    public FssAdminUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssAdminUserException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssAdminUserException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssAdminUserException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
