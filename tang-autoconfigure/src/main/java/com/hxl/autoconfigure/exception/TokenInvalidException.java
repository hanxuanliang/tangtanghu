package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 令牌无效 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:22
 */
@Getter
public class TokenInvalidException extends HttpException {

    protected int code = Code.TOKEN_INVALID.getCode();

    protected int httpCode = HttpStatus.UNAUTHORIZED.value();

    public TokenInvalidException() {
        super(Code.TOKEN_INVALID.getDescription());
    }

    public TokenInvalidException(String message) {
        super(message);
    }

    public TokenInvalidException(int code) {
        super(Code.TOKEN_INVALID.getDescription());
        this.code = code;
    }

    public TokenInvalidException(int code, String message) {
        super(message);
        this.code = code;
    }
}
