package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 资源不存在 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 20:20
 */
@Getter
public class NotFoundException extends HttpException {

    private int code = Code.NOT_FOUND.getCode();

    private int httpCode = HttpStatus.NOT_FOUND.value();

    public NotFoundException() {
        super(Code.NOT_FOUND.getDescription());
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int code) {
        super(Code.NOT_FOUND.getDescription());
        this.code = code;
    }

    public NotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }

}
