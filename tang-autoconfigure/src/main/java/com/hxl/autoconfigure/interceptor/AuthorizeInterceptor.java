package com.hxl.autoconfigure.interceptor;

import com.hxl.autoconfigure.interfaces.AuthorizeVerifyResolver;
import com.hxl.core.annotation.RouteMeta;
import com.hxl.core.enums.UserLevel;
import com.hxl.core.utils.AnnotationUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * 权限拦截器实际处理
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 21:54
 */
@Component
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private AuthorizeVerifyResolver authorizeVerifyResolver;

    private String[] excludeMethods;

    public AuthorizeInterceptor(String[] excludeMethods) {
        // Before：是否加入构造器中，未知？可能会删除此做法！【使用@Resource解决一下】
        // this.authorizeVerifyResolver = authorizeVerifyResolver;
        // 参照文章：http://www.itmuch.com/other/idea-mybatis-warning/#%E6%96%B9%E6%B3%952%EF%BC%9A%E7%94%A8-Resource-%E6%9B%BF%E6%8D%A2-Autowired
        this.excludeMethods = excludeMethods;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (checkExclude(request.getMethod())) {
            // 如果检测到请求中的某些方法与 excludeMethod 相同的情况下，就直接返回，不做处理。
            // 如：OPTIONS 方法
            return true;
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RouteMeta meta = method.getAnnotation(RouteMeta.class);
            if (meta == null) {
                return this.handleMeta(request, response, method);
            } else {
                return this.handleMeta(request, response, method, meta);
            }
        } else {
            return authorizeVerifyResolver.handleNotHandlerMethod(request, response, handler);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        authorizeVerifyResolver.handlePostHandle(request, response, handler, modelAndView);
    }

    private boolean handleMeta(HttpServletRequest request, HttpServletResponse response, Method method) {
        // 如果没有挂载在权限系统中，转移到此方法执行。
        Annotation[] annotations = method.getAnnotations();
        UserLevel level = AnnotationUtil.findRequired(annotations);
        switch (level) {
            case LOGIN:
                return authorizeVerifyResolver.handleLogin(request, response, null);
            case GROUP:
                return false;
            case ADMIN:
                return authorizeVerifyResolver.handleAdmin(request, response, null);
            default:
                return true;
        }
    }

    private boolean handleMeta(HttpServletRequest request, HttpServletResponse response, Method method, RouteMeta meta) {
        // 如果权限存在 meta，可是没有 mount，则当做没有 meta 转交给上面的方法处理。
        if (!meta.mount()) {
            return this.handleMeta(request, response, method);
        }
        Annotation[] annotations = method.getAnnotations();
        UserLevel level = AnnotationUtil.findRequired(annotations);
        switch (level) {
            case LOGIN:
                return authorizeVerifyResolver.handleLogin(request, response, meta);
            case ADMIN:
                return authorizeVerifyResolver.handleAdmin(request, response, meta);
            default:
                return true;
        }
    }

    private boolean checkExclude(String method) {
        for (String excludeMethod : excludeMethods) {
            if (method.equals(excludeMethod)) {
                return true;
            }
        }
        return false;
    }
}
