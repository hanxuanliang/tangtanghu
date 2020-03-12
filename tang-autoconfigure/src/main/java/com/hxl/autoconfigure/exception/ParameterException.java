package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 参数错误 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:15
 */
public class ParameterException extends HttpException {

    @Getter
    protected int httpCode = HttpStatus.BAD_REQUEST.value();

    @Getter
    protected int code = Code.PARAMETER_ERROR.getCode();

    private Map<String, Object> errors = new HashMap<>();

    public ParameterException() {
        super(Code.PARAMETER_ERROR.getDescription());
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(int code) {
        super(Code.PARAMETER_ERROR.getDescription());
        this.code = code;
    }

    public ParameterException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ParameterException(Map<String, Object> errors) {
        this.errors = errors;
    }

    public ParameterException addError(String key, Object val) {
        this.errors.put(key, val);
        return this;
    }

    @Override
    public String getMessage() {
        if (errors.isEmpty()) {
            return super.getMessage();
        }
        return errors.toString();
    }
}
