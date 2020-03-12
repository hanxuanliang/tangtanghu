package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 授权 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:26
 */
@Getter
public class AuthorizationException extends HttpException {

    protected int code = Code.UN_AUTHORIZATION.getCode();

    protected int httpCode = HttpStatus.UNAUTHORIZED.value();

    public AuthorizationException() {
        super(Code.UN_AUTHORIZATION.getDescription());
    }

    public AuthorizationException(int code) {
        super(Code.UN_AUTHORIZATION.getDescription());
        this.code = code;
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(int code, String message) {
        super(message);
        this.code = code;
    }
}
