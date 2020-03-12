package com.hxl.autoconfigure.exception;

import com.hxl.autoconfigure.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Description: 认证 异常类
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:26
 */
@Getter
public class CertificationException extends HttpException {

    protected int code = Code.UN_CERTIFICATION.getCode();

    protected int httpCode = HttpStatus.UNAUTHORIZED.value();

    public CertificationException() {
        super(Code.UN_CERTIFICATION.getDescription());
    }

    public CertificationException(String message) {
        super(message);
    }

    public CertificationException(int code) {
        super(Code.UN_CERTIFICATION.getDescription());
        this.code = code;
    }

    public CertificationException(int code, String message) {
        super(message);
        this.code = code;
    }
}
