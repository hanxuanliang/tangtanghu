package com.hxl.autoconfigure.validator;

import com.hxl.autoconfigure.validator.annotation.LongList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Long List 列表校验器
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 16:56
 */
public class LongListValidator implements ConstraintValidator<LongList, List<Long>> {

    private long min;
    private long max;
    private boolean allowBlank;

    @Override
    public void initialize(LongList constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        this.allowBlank = constraintAnnotation.allowBlank();
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        if (values == null || values.isEmpty()) { return allowBlank; }

        for (Long value : values) {
            if (value < min || value > max) { return false; }
        }
        return true;
    }
}
