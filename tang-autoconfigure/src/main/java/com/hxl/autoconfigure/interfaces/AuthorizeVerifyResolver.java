package com.hxl.autoconfigure.interfaces;

import com.hxl.core.annotation.RouteMeta;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限认证接口规范
 *
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

    /**
     * 处理当前的 handler 不是 HandlerMethod 的情况
     *
     * @param request  http请求
     * @param response http响应
     * @param handler  处理器
     * @return 是否处理成功
     * @date: 2020/3/13 17:26
     */
    boolean handleNotHandlerMethod(HttpServletRequest request, HttpServletResponse response, Object handler);

    /**
     * 后置处理
     *
     * @param request  http请求
     * @param response http响应
     * @param handler  处理器
     * @param modelAndView  视图
     * @date: 2020/3/13 21:10
     */
    void handlePostHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView);

}
