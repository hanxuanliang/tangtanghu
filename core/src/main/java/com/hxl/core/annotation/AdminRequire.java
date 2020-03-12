package com.hxl.core.annotation;

import com.hxl.core.enums.UserLevel;

import java.lang.annotation.*;

/**
 * @Description: 管理员权限标注
 * @Author: hanxuanliang
 * @Date: 2020/3/12 9:29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Required(level = UserLevel.ADMIN)
public @interface AdminRequire {
}
