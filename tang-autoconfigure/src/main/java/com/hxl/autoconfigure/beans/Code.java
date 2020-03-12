package com.hxl.autoconfigure.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Description: 消息码
 * @Author: hanxuanliang
 * @Date: 2020/3/12 20:10
 */
@Getter
@AllArgsConstructor
public enum  Code {

    SUCCESS(0, "成功"),

    CREATED(1, "创建成功"),

    FAIL(10200, "失败"),

    UN_CERTIFICATION(10000, "认证失败"),

    UN_AUTHORIZATION(10010, "授权失败"),

    NOT_FOUND(10020, "资源不存在"),

    PARAMETER_ERROR(10030, "参数错误"),

    TOKEN_INVALID(10040, "令牌失效"),

    TOKEN_EXPIRED(10050, "令牌过期"),

    REPEAT(10060, "字段重复"),

    INTERNAL_SERVER_ERROR(9999, "服务器未知错误"),

    FORBIDDEN(10070, "禁止操作"),

    METHOD_NOT_ALLOWED(10080, "请求方法不允许"),

    REFRESH_FAILED(10100, "刷新令牌获取失败"),

    FILE_TOO_LARGE(10110, "文件体积过大"),

    FILE_TOO_MANY(10120, "文件数量过多"),

    FILE_EXTENSION(10130, "文件扩展名不符合规范"),

    REQUEST_LIMIT(10140, "请求过于频繁，请稍后重试"),
    ;

    private int code;

    private String description;

}
