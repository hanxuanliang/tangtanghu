package com.hxl.autoconfigure.interfaces;

import com.hxl.core.annotation.RouteMeta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 权限认证接口规范
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:35
 */
public interface AuthorizeVerifyResolver {

    /**
     * 处理 LoginRequire 的情况
     *
     * @param request  http请求
     * @param response http响应
     * @param meta     路由元信息
     * @return 是否处理成功
     * @date: 2020/3/12 21:38
     */
    boolean handleLogin(HttpServletRequest request, HttpServletResponse response, RouteMeta meta);

    /**
     * 处理 GroupRequire 的情况
     *
     * @param request  http请求
     * @param response http响应
     * @param meta     路由元信息
     * @return 是否处理成功
     * @date: 2020/3/12 21:47
     */
    boolean handleGroup(HttpServletRequest request, HttpServletResponse response, RouteMeta meta);

    /**
     * 处理 AdminRequire 的情况
     *
     * @param request  http请求
     * @param response http响应
     * @param meta     路由元信息
     * @return 是否处理成功
     * @date: 2020/3/12 21:48
     */
    boolean handleAdmin(HttpServletRequest request, HttpServletResponse response, RouteMeta meta);

}
