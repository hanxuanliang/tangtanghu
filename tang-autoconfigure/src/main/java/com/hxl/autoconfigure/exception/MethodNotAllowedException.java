package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 请求方法不允许 异常类
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 20:36
 */
@Getter
public class MethodNotAllowedException extends HttpException {

    protected int code = Code.METHOD_NOT_ALLOWED.getCode();

    protected int httpCode = HttpStatus.METHOD_NOT_ALLOWED.value();

    public MethodNotAllowedException() {
        super(Code.METHOD_NOT_ALLOWED.getDescription());
    }

    public MethodNotAllowedException(String message) {
        super(message);
    }

    public MethodNotAllowedException(int code) {
        super(Code.METHOD_NOT_ALLOWED.getDescription());
        this.code = code;
    }

    public MethodNotAllowedException(int code, String message) {
        super(message);
        this.code = code;
    }
}
