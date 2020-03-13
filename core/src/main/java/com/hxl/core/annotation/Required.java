package com.hxl.core.annotation;

import com.hxl.core.enums.UserLevel;

import java.lang.annotation.*;

/**
 * 权限需要标注
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 9:30
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Required {

    UserLevel level() default UserLevel.TOURIST;
}
