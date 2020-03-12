package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import com.hxl.autoconfigure.interfaces.BaseResponse;
import org.springframework.http.HttpStatus;

/**
 * @Description: Http 异常基类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 20:02
 */
public class HttpException extends RuntimeException implements BaseResponse {

    protected int httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

    protected int code = Code.INTERNAL_SERVER_ERROR.getCode();

    public HttpException() {
        super(Code.INTERNAL_SERVER_ERROR.getDescription());
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(int code) {
        super(Code.INTERNAL_SERVER_ERROR.getDescription());
        this.code = code;
    }

    public HttpException(int code, int httpCode) {
        super(Code.INTERNAL_SERVER_ERROR.getDescription());
        this.code = code;
        this.httpCode = httpCode;
    }

    public HttpException(int code, String message) {
        super(message);
        this.code = code;
    }

    public HttpException(int code, int httpCode, String message) {
        super(message);
        this.code = code;
        this.httpCode = httpCode;
    }

    @Override
    public int getHttpCode() {
        return this.httpCode;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
