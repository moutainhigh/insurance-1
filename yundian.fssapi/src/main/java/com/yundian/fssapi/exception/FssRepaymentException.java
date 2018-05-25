package com.yundian.fssapi.exception;

public class FssRepaymentException extends RuntimeException{

    private String code;

    public FssRepaymentException(String message) {
        super(message);
    }

    public FssRepaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssRepaymentException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssRepaymentException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssRepaymentException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
