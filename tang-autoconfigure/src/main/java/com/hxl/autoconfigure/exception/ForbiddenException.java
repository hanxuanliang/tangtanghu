package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 禁止操作 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 20:29
 */
@Getter
public class ForbiddenException extends HttpException {

    private int code = Code.FORBIDDEN.getCode();

    private int httpCode = HttpStatus.FORBIDDEN.value();

    public ForbiddenException() {
        super(Code.FORBIDDEN.getDescription());
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(int code) {
        super(Code.FORBIDDEN.getDescription());
        this.code = code;
    }

    public ForbiddenException(int code, String message) {
        super(message);
        this.code = code;
    }

}
