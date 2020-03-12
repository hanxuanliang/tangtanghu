package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 令牌过期 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:21
 */
@Getter
public class TokenExpiredException extends HttpException {

    private int code = Code.TOKEN_EXPIRED.getCode();

    private int httpCode = HttpStatus.UNAUTHORIZED.value();

    public TokenExpiredException() {
        super(Code.TOKEN_EXPIRED.getDescription());
    }

    public TokenExpiredException(String message) {
        super(message);
    }

    public TokenExpiredException(int code) {
        super(Code.TOKEN_EXPIRED.getDescription());
        this.code = code;
    }

    public TokenExpiredException(int code, String message) {
        super(message);
        this.code = code;
    }
}
