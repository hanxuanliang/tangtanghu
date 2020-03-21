package com.hxl.autoconfigure.validator;

import com.hxl.autoconfigure.validator.annotation.EqualField;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/3/13 21:42
 */
public class EqualFieldValidator implements ConstraintValidator<EqualField, Object> {

    private String srcField;

    private String dstField;

    @Override
    public void initialize(EqualField constraintAnnotation) {
        this.srcField = constraintAnnotation.srcField();
        this.dstField = constraintAnnotation.dstField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Class<?> clazz = object.getClass();

        Field srcField = ReflectionUtils.findField(clazz, this.srcField);
        Field dstField = ReflectionUtils.findField(clazz, this.dstField);
        try {
            assert srcField != null;
            srcField.setAccessible(true);
            assert dstField != null;
            dstField.setAccessible(true);
            String src = (String) srcField.get(object);
            String dst = (String) dstField.get(object);
            if (src.equals(dst)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
