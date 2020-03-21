package com.hxl.autoconfigure.validator.annotation;

import com.hxl.autoconfigure.validator.EqualFieldValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 字段相等标识
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/13 21:36
 */
@Target({TYPE, METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EqualFieldValidator.class})
public @interface EqualField {

    String srcField() default "";

    String dstField() default "";

    String message() default "两个字段必须相等";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
