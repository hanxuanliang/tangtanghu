package com.hxl.core.utils;

import com.hxl.core.annotation.Required;
import com.hxl.core.enums.UserLevel;

import java.lang.annotation.Annotation;

/**
 * 注解工具类
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/13 16:39
 */
public class AnnotationUtil {

    public static UserLevel findRequired(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            Required required = aClass.getAnnotation(Required.class);
            if (required != null) {
                return required.level();
            }
        }
        return UserLevel.TOURIST;
    }
}
