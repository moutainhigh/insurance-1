package com.yundian.fssapi.exception;

public class FssDealerException extends RuntimeException{

    private String code;

    public FssDealerException(String message) {
        super(message);
    }

    public FssDealerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssDealerException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssDealerException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssDealerException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
