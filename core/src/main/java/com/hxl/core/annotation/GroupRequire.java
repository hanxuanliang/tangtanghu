package com.hxl.core.annotation;

import com.hxl.core.enums.UserLevel;

import java.lang.annotation.*;

/**
 * 用户组权限标注
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 9:34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Required(level = UserLevel.GROUP)
public @interface GroupRequire {
}
