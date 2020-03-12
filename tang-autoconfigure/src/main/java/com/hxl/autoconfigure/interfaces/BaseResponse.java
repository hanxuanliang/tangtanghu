package com.hxl.autoconfigure.interfaces;

/**
 * @Description: 定义返回对象的接口规范
 * @Author: hanxuanliang
 * @Date: 2020/3/12 20:03
 */
public interface BaseResponse {

    /**
     * 返回的信息
     * @return 返回的信息
     * @date: 2020/3/12 20:04
     */
    String getMessage();

    /**
     * 返回给前端的 http 状态码
     * @return: 返回给前端的 http status，表示当前请求的状态;
     *          推荐每一种 http status 都应该有一个相应的异常类
     * @date: 2020/3/12 20:05
     */
    int getHttpCode();

    /**
     * 消息码
     * @return: 每个消息码都有默认对应的英文消息
     * @date: 2020/3/12 20:06
     */
    int getCode();
}
