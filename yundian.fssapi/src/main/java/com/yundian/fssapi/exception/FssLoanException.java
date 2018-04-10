package com.yundian.fssapi.exception;

public class FssLoanException extends RuntimeException{

    private String code;

    public FssLoanException(String message) {
        super(message);
    }

    public FssLoanException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssLoanException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssLoanException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssLoanException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
