package com.hxl.autoconfigure.validator.annotation;

import com.hxl.autoconfigure.validator.LongListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Long List 校验
 * 【在分组id中可能使用，后期可能会扩大职能(可能会修改)】
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 16:50
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LongListValidator.class})
public @interface LongList {

    /**
     * 校验信息
     *
     * @return 返回校验信息
     */
    String message() default "Integer list cannot can't be blank";

    /**
     * 每一个整数的最小值
     *
     * @return 最小值
     */
    long min() default 0;

    /**
     * 每一个整数的最大值
     *
     * @return 最大值
     */
    long max() default Long.MAX_VALUE;

    /**
     * 允许List中的数为 NULL 和 size == 0
     *
     * @return 是否可以为空
     */
    boolean allowBlank() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
