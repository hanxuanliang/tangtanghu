package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 失败 异常
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:20
 */
@Getter
public class FailedException extends HttpException {

    private int code = Code.FAIL.getCode();

    private int httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public FailedException() {
        super(Code.FAIL.getDescription());
    }

    public FailedException(String message) {
        super(message);
    }

    public FailedException(int code) {
        super(Code.FAIL.getDescription());
        this.code = code;
    }

    public FailedException(int code, String message) {
        super(message);
        this.code = code;
    }
}
