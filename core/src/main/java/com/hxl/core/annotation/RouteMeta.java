package com.hxl.core.annotation;

import java.lang.annotation.*;

/**
 * 路由元信息
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 9:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RouteMeta {

    // 权限名
    String permission() default "";

    // 权限模块
    String module() default "";

    // 是否挂载在权限系统
    boolean mount() default false;
}
