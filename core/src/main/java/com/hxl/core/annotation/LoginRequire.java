package com.hxl.core.annotation;

import com.hxl.core.enums.UserLevel;

import java.lang.annotation.*;

/**
 * @Description: 登陆权限标注
 * @Author: hanxuanliang
 * @Date: 2020/3/12 9:36
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Required(level = UserLevel.LOGIN)
public @interface LoginRequire {
}
