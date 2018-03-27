package com.yundian.fssapi.exception;
/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 16/8/2.
 */


/**
 * 修改历史
 * 修改日期         修改人          问题类型           说明
 */
public class FssLoanStatusTransformException extends RuntimeException{

    private String code;

    public FssLoanStatusTransformException(String message) {
        super(message);
    }

    public FssLoanStatusTransformException(String message, Throwable cause) {
        super(message, cause);
    }

    public FssLoanStatusTransformException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FssLoanStatusTransformException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FssLoanStatusTransformException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }
}
